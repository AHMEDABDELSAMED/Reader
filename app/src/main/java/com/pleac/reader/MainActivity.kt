package com.pleac.reader

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.ActionMode
import android.view.Menu
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.pleac.reader.Actions.Action
import com.pleac.reader.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){


    //use ViewBinding to access the components inside the xml file
    private lateinit var bin:ActivityMainBinding

    private var approximatePercentage:Float=1.0F
    private var typeColorBack=false
    private var showColorBar=false
    private var searchshow=false
    private var countClickForZoom=0
    private var mActionMode: ActionMode? = null
    lateinit var  webView:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin =ActivityMainBinding.inflate(layoutInflater)
        setContentView(bin.root)
        webView = bin.web
        webView.settings.javaScriptEnabled = true
        webView.settings.defaultTextEncodingName = "utf-8"
            // load html content
        webView.loadDataWithBaseURL(null, Action.getHtmlContent(), "text/html", "UTF-8", null)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                return Action.goToLinkOutApp(webView,url)
            }
        }

        componentEvents()

    }
    private fun componentEvents (){
        bin.search.setOnClickListener {
            if (!searchshow){
                bin.editText.visibility=View.VISIBLE
                searchshow=true
            }else{
                searchshow=false
                bin.editText.visibility=View.GONE
            }
        }
        bin.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                webView.clearMatches()
                webView.findAllAsync(s.toString());

            }

            override fun afterTextChanged(s: Editable?) {


            }
        })
        // load script when user Clicked
        bin.zoomin.setOnClickListener {
            if (countClickForZoom<10){
                countClickForZoom++
                Action.increaseFontSize(webView,approximatePercentage+0.1F)
            }



        }
        bin.zoomout.setOnClickListener {
            if (countClickForZoom>-10){
                countClickForZoom--
                Action.increaseFontSize(webView,approximatePercentage-0.1F)
            }


        }
        bin.colortext.setOnClickListener {
            if (!showColorBar){
                bin.color.visibility= View.VISIBLE
                showColorBar=true
                typeColorBack=false

            }else{
                bin.color.visibility= View.GONE
                showColorBar=false
            }


        }
        bin.colorback.setOnClickListener {
            if (!showColorBar){
                bin.color.visibility= View.VISIBLE
                showColorBar=true
                typeColorBack=true

            }else{
                bin.color.visibility= View.GONE
                showColorBar=false
            }

        }
        bin.color.setOnColorChangeListener { progress, color ->
            val color = String.format("#%06X", 0xFFFFFF and color)
            if (typeColorBack){
                Action.changeBackgroundColor(color, webView)
            }else{
                Action.changeTextColor(color,webView)
            }



        }
    }

    //to change the menu when highlighting
    override fun onActionModeStarted(mode: ActionMode) {
        if (mActionMode == null) {
            mActionMode = mode
            val menu = mode.menu
            // Remove the default menu items (select all, copy, paste, search)
            menu.clear()



            val shareItem = menu?.add(Menu.NONE, R.id.item_1, Menu.NONE, "مشاركة النص")
            shareItem?.setOnMenuItemClickListener {
                true
            }

            val highlight = menu?.add(Menu.NONE, R.id.item_2, Menu.NONE, "تظليل")
            highlight?.setOnMenuItemClickListener {
                Action.highlight(webView = bin.web)

                true
            }





        }
        super.onActionModeStarted(mode)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onActionModeFinished(mode: ActionMode?) {
        mActionMode = null
        val menu = mode?.menu
        // Remove the default menu items (select all, copy, paste, search)
        menu?.clear()

        super.onActionModeFinished(mode)
    }
    }











