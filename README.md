# pdf-generator
Using Java to generate PDF file

Java + Maven

APIs:

[Flying-saucer](https://code.google.com/p/flying-saucer/)

[Freemarker](http://freemarker.org/)

[Itext](http://itextpdf.com/)


It's flexible to create your HTML+CSS in freemarkter tempalte to generate the PDF. 


## Example
It supports for Bookmarks in navigation bar. In the example, users data is from User.java object
![alt tag](https://github.com/xiang-lee/pdf-generator/blob/master/images/example1.png)


## Usage

###### Using Eclipse
If you are using eclipse, you can import "Existing Maven Project", set the PDF output path in Runner.java and run it. Enjoy!


###### Invoke PdfGenerator:

```
//The output path of your PDF file
String outputFilePath = "C:\\PDFSample\\samplePDF.pdf";

//The path of your freemarker template
String tampleFile = "freemarker_template.html";

//you can put any variables you want, so that you can use them in freemarker template
Map<String,Object> variables = new HashMap<String,Object>();
variables.put("users",users);

String htmlStr = HtmlGenerator.generate(tampleFile, variables);        
PdfGenerator.generate(htmlStr, new FileOutputStream(outputFilePath));  
```

###### Freemarker template
You can easily display the data like HTML + CSS, the users variable is from variables.put("users",users) in the example
```
<table border="1"  cellspacing="0" cellpadding="0" align="center"> 
	<thead>
      <tr style="background:#CCC0DA">
         <th align="center">Id</th>
         <th align="center">Username</th>
         <th align="center">Age</th>
      </tr>
     </thead>
    <#list 1..users?size as i>
        <#if i%2==0> 
            <tr style="background:#FABF8F">
        <#else>
            <tr style="background:#C4D79B">
        </#if>
            <td width="189" align="center"><p align="center">${users[i-1].id}</p></td> 
            <td width="189" align="center"><p align="center">${users[i-1].username}</p></td> 
            <td width="189" align="center"><p align="center">${users[i-1].age}</p></td>    
        </tr>
    </#list>
</table>
```
