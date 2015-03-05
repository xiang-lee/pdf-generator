# pdf-generator
Using Java to generate PDF file

Java + Maven

APIs:

[Flying-saucer](https://code.google.com/p/flying-saucer/)

[Freemarker](http://freemarker.org/)

[Itext](http://itextpdf.com/)


It's flexible to create your HTML+CSS in freemarkter tempalte to generate the PDF. 

## Usage

Invoke PdfGenerator:

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

In your freemarker template, you can easily display the data like HTML + CSS, the users variable is from variables.put("users",users) in the example
```
<table border="1"  cellspacing="0" cellpadding="0" align="center"> 
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
