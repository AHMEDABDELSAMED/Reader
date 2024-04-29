package com.pleac.reader.Actions

import android.content.Intent
import android.net.Uri
import android.view.ActionMode
import android.webkit.WebView
import android.widget.Toast

object Action {

    fun increaseFontSize(webView: WebView, increment: Float) {
        val script = "javascript:(function() { " +
                "var elements = document.querySelectorAll('*');" +
                "for (var i = 0; i < elements.length; i++) {" +
                "var fontSize = window.getComputedStyle(elements[i], null).getPropertyValue('font-size');" +
                "var newSize = parseFloat(fontSize) * $increment;" + // Increase the size by a specified percentage
                "elements[i].style.setProperty('font-size', newSize + 'px', 'important');" + // difference between sizes
                "}" +
                "})()"
        webView.loadUrl(script)
    }
    //The book written in html can get from any API
    fun get():String{
        return "<!DOCTYPE html>\n" +
                "\t\t  <html lang=\"en\">\n" +
                "\t\t  <head>\n" +
                "\t\t  <meta charset=\"UTF-8\"> \n" +
                "\t\t  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "\t\t  <title>موضوعات وفقرات</title> \n" +
                "\t\t  <style>    \n" +
                " \n" +
                "          body {\n" +
                "             direction: rtl;\n" +
                "             text-align: right; \n" +
                "             }\n" +
                "\t\t  h2 { \n" +
                "              color: blue;       \n" +
                "\t\t      font-size: 30px;      \n" +
                "\t\t       cursor: pointer;  \n" +
                "             }     \n" +
                "\t\t  a {  text-decoration: none; }      \n" +
                "\t\t  ::selection {  background-color:yellow;     } \n" +
                "\t\t  </style>\n" +
                "\t\t  </head>"+ getHtmlContent()+

                "\t\t   </html>"
    }
    fun getHtmlContent(): String {
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>موضوعات وفقرات</title>
             <style>
                body {   
                   direction: rtl;
                   text-align: right;
                 }
              h2 {
                color: blue;
                font-size: 30px;
                cursor: pointer;
                 }
               a {
                  text-decoration: none;
                }
                ::selection {
                    background-color: yellow;
               }
           </style>
           </head>

		  <body> 
		  <a href="https://www.for9a.com/learn/%D9%83%D9%8A%D9%81%D9%8A%D8%A9-%D9%83%D8%AA%D8%A7%D8%A8%D8%A9-%D9%85%D9%82%D8%A7%D9%84-%D8%AE%D8%B7%D9%88%D8%A7%D8%AA-%D8%B9%D9%85%D9%84%D9%8A%D8%A9-%D9%84%D9%83%D8%AA%D8%A7%D8%A8%D8%A9-%D9%85%D9%82%D8%A7%D9%84-%D8%A3%D9%83%D8%A7%D8%AF%D9%8A%D9%85%D9%8A-%D8%A7%D8%AD%D8%AA%D8%B1%D8%A7%D9%81%D9%8A" target="_blank">اضغط هنا للذهاب  الى المصدر </a>   
		  <a href="#section1"><h2>عنوان 1</h2></a>   
		  <a href="#section2"><h2>عنوان 2</h2></a>  
		  <a href="#section3"><h2>عنوان 3</h2></a>   
		  <a href="#section4"><h2>عنوان 4</h2></a> 
		  <a href="#section5"><h2>عنوان 5</h2></a> 
		  <a href="#section6"><h2>عنوان 6</h2></a> 

		  <!-- فقرات -->     <div id="section1">  
		   <h2>عنوان 1</h2>     
		                  <p>تتأرجح بريطانيا <span style="color:red;">سياسيا واقتصاديا بين اليمين واليسار</span>  يمثل مصالح الطبقة العاملة، فصار اليسار يأتي إلى الحكم بعد أن يتخبط اليمين، بينما يعود اليمين إلى الحكم إثر تطرف اليسار.  اليمين، المتمثل بحزب المحافظين، يحكم بريطانيا منذ عام 2010، لكنه بدأ معتدلا في السنوات الخمس الأولى، في<span style="color:green;"> انتخب الحزب وزيرة الداخلية، تريزا مي، المعتدلة</span> ظل زعامة السياسي الوسطي ديفيد كاميرون، ثم اتجه يمينا، مُلْجِئاً كاميرون إلى إجراء استفتاء عام حول عضوية بريطانيا في الاتحاد الأوروبي، فكانت نتيجة الاستفتاء لصالح الانسحاب، بفارق ضئيل، فاضطر كاميرون إلى الاستقالة عام 2016، إذ صار صعبا عليه البقاء في السلطة، بينما الاستفتاء سار عكس توجهاته. ،<span style="color:blue;">منذ مئة عام تقريبا، بعدما أسست نقابات العمال عام 1900 حزبا يساريا</span> التي كانت تؤيد البقاء في أوروبا، لكنها اضطرت للسير يمينا، وفق نتائج الاستفتاء وتوجهات غالبية مؤيدي الحزب، فلم تستطع الاستمرار طويلا، إذ اضطرت إلى الاستقالة عام 2019، بعد أن رفض البرلمان خطتها للانسحاب من الاتحاد الأوروبي، فآلت الزعامة إلى اليميني المتشدد، بوريس جونسون، الذي قاد حملة الانسحاب من أوروبا</p>   
		  </div>   
           <div id="section2">      
		   <h2>عنوان 2</h2>    
		                  <p>تعدّ كتابة المقالات الأكاديمية واحدة من أهمّ عناصر النجاح خلال المرحلة الدراسية، الثانوية أو الجامعية على حدّ السواء. ويواجه الكثير من الطلاب الذين يفتقرون إلى موهبة الكتابة، صعوبة في إعداد المقالات الأكاديمية وتجهيزها. لكن، ما لا يعرفه هؤلاء الطلاب، هو أن المقال الأكاديمي، يختلف اختلافًا كبيرًا عن الكتابة الإبداعية، حيث أنّه مبني على قواعد محدّدة إن تعلّمتها والتزمت بها أمكنك كتابة مقال أكاديمي احترافي وناجح.
وهذا بالضبط ما سنتطرّق للحديث عنه هنا...فلنتعرّف معًا على المقال الأكاديمي، وأهمّ النصائح والخطوات لكتابته.</p>                          
		  </div>
          <div id="section3">     
		  <h2>عنوان 3</h2>    
		                 <p>كما يعبّر عنها الاسم، فهذه المرحلة هي التي تتمّ فيها عملية التحضير والإعداد للمقال الذي ستكتبه. وتعدّ أهمّ المراحل، لأنك إن تمكّنت من إتمامها بنجاح، فقد وضعت بذلك أساسًا قويًا لمقالك، ولن تكون المراحل المقبلة سوى عملية لترتيب ما جمعته وعثرت عليه في هذه المرحلة.
1- فهم المطلوب في المقال</p>                         
          </div> 
          <div id="section4">  
		  <h2>عنوان 4</h2>    
		                 <p> عملية التحضير والإعداد للمقال الذي ستكتبه. وتعدّ أهمّ المراحل، لأنك إن تمكّنت من<span style="color:blue;">كما يعبّر عنها الاسم، فهذه المرحلة هي التي تتمّ فيها</span>  إتمامها بنجاح، فقد وضعت بذلك أساسًا قويًا لمقالك، ولن تكون المراحل المقبلة سوى عملية لترتيب ما جمعته وعثرت عليه في هذه المرحلة.
1- فهم المطلوب في المقال</p>                         
          </div>     
          <div id="section5">  
		  <h2>عنوان 5</h2>    
		                 <p>تتأرجح بريطانيا سياسيا واقتصاديا بين اليمين واليسار منذ مئة عام تقريبا، بعدما أسست نقابات العمال عام 1900 حزبا يساريا يمثل مصالح الطبقة العاملة، فصار اليسار يأتي إلى الحكم بعد أن يتخبط اليمين، بينما يعود اليمين إلى الحكم إثر تطرف اليسار.  اليمين، المتمثل بحزب المحافظين، يحكم بريطانيا منذ عام 2010، لكنه بدأ معتدلا في السنوات الخمس الأولى، في ظل زعامة السياسي الوسطي ديفيد كاميرون، ثم اتجه يمينا، مُلْجِئاً كاميرون إلى إجراء استفتاء عام حول عضوية بريطانيا في الاتحاد الأوروبي، فكانت نتيجة الاستفتاء لصالح الانسحاب، بفارق ضئيل، فاضطر كاميرون إلى الاستقالة عام 2016، إذ صار صعبا عليه البقاء في السلطة، بينما الاستفتاء سار عكس توجهاته.  انتخب الحزب وزيرة الداخلية، تريزا مي، المعتدلة، التي كانت تؤيد البقاء في أوروبا، لكنها اضطرت للسير يمينا، وفق نتائج الاستفتاء وتوجهات غالبية مؤيدي الحزب، فلم تستطع الاستمرار طويلا، إذ اضطرت إلى الاستقالة عام 2019، بعد أن رفض البرلمان خطتها للانسحاب من الاتحاد الأوروبي، فآلت الزعامة إلى اليميني المتشدد، بوريس جونسون، الذي قاد حملة الانسحاب من أوروبا</p>  
		  </div>     
           <div id="section6">
		   <h2>عنوان 6</h2>    
		                 <p>تعدّ كتابة المقالات الأكاديمية واحدة من أهمّ عناصر النجاح خلال المرحلة الدراسية، الثانوية أو الجامعية على حدّ السواء. ويواجه الكثير من الطلاب الذين يفتقرون إلى موهبة الكتابة، صعوبة في إعداد المقالات الأكاديمية وتجهيزها. لكن، ما لا يعرفه هؤلاء الطلاب، هو أن المقال الأكاديمي، يختلف اختلافًا كبيرًا عن الكتابة الإبداعية، حيث أنّه مبني على قواعد محدّدة إن تعلّمتها والتزمت بها أمكنك كتابة مقال أكاديمي احترافي وناجح.

وهذا بالضبط ما سنتطرّق للحديث عنه هنا...فلنتعرّف معًا على المقال الأكاديمي، وأهمّ النصائح والخطوات لكتابته.</p>                     
		   </div> 
         </body>
         
          </html>
        """
    }
    fun highlight(webView: WebView){
        webView.evaluateJavascript("(function(){ return window.getSelection().toString(); })()") { value ->
            val selectedText = value?.replace("\"", "") // Remove expression tags for selected text
            selectedText?.let {
                val script = "javascript: (function() { " +
                        "var sel = window.getSelection(); " +
                        "var range = sel.getRangeAt(0); " +
                        "var replacementNode = document.createElement('span'); " +
                        "replacementNode.style.backgroundColor = '#FFFF00';" + //  use yellow color
                        "replacementNode.innerHTML = sel.toString(); " +
                        "range.deleteContents(); " +
                        "range.insertNode(replacementNode); " +
                        "})()"
                webView.evaluateJavascript(script, null)
            }
        }
    }
    fun goToLinkOutApp(view: WebView?,url: String?):Boolean{
        if (url != null) {
            if (url.startsWith("http://") || url.startsWith("https://")) {
                view?.context?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                return true
            }

        }
        return false
    }
    fun changeTextColor(color:String,webView: WebView){
        val script = "javascript:(function() { " +
                "var elements = document.querySelectorAll('body');" +
                "for (var i = 0; i < elements.length; i++) {" +
                "elements[i].style.color='$color';" +
                "}" +
                "})()"
        webView.loadUrl(script)

    }
    fun changeBackgroundColor(color:String,webView: WebView){


        val script = "javascript:(function() { " +
                "document.body.style.backgroundColor = '$color';" +
                "})()"
        webView.loadUrl(script)
    }


}