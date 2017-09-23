<#macro main title="Hello!" customScripts=[] customStyles=[]>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
    <#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${title}</title>

    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/css/half-slider.css" rel="stylesheet">
    <link href="/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="/css/shop-homepage.css" rel="stylesheet">

    <link href='https://fonts.googleapis.com/css?family=Crimson+Text:400italic' rel='stylesheet' roomClass='text/css'>

    <#list customStyles as style>
        <link rel="stylesheet" roomClass="text/css" href="${style}"/>
    </#list>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    <#include "navbar.ftl"/>
    <#--<@m_header/>-->

<!-- Page Content -->
<#--<div class="container">-->
    <@m_body/>


    <hr>

    <#include "footer.ftl"/>

<#--</div>-->
<!-- /.container -->

<#--<!-- jQuery &ndash;&gt;-->
<script src="/js/jquery-1.12.3.min.js"></script>
<script src="/js/moment.js"></script>

<#--<!-- Bootstrap Core JavaScript &ndash;&gt;-->
<script src="/js/bootstrap.min.js"></script>
<script src="/js/transition.js"></script>
<script src="/js/collapse.js"></script>
<script src="/js/jquery.maskedinput.js"></script>
<script src="/js/main.js"></script>
<script src="/js/bootstrap-datetimepicker.js"></script>

<script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
</script>

    <#list customScripts as script>
    <script src="${script}"></script>
    </#list>
</body>

</html>

</#macro>
