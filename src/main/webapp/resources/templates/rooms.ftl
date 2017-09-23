<#include "main.ftl"/>
<#macro m_body>



<div class="container">

    <div class="row">
        <div class="page-header text-center" >
            <h2><@m_header/></h2>
        </div>


        <div class="col-md-3">
            <p class="lead">Room types</p>
            <div class="list-group">

                <a href="/rooms/standart" class="list-group-item">Standart</a>
                <a href="/rooms/lux" class="list-group-item">Lux</a>
                <a href="/rooms/apartments" class="list-group-item">Apartaments</a>
            </div>
        </div>

        <div class="col-md-9">

        <#--<div class="row carousel-holder">-->

        <#--<div class="col-md-12">-->
        <#--<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">-->
        <#--<ol class="carousel-indicators">-->
        <#--<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>-->
        <#--<li data-target="#carousel-example-generic" data-slide-to="1"></li>-->
        <#--<li data-target="#carousel-example-generic" data-slide-to="2"></li>-->
        <#--</ol>-->
        <#--<div class="carousel-inner">-->
        <#--<div class="item active">-->
        <#--<img class="slide-image" src="http://placehold.it/800x300" alt="">-->
        <#--</div>-->
        <#--<div class="item">-->
        <#--<img class="slide-image" src="http://placehold.it/800x300" alt="">-->
        <#--</div>-->
        <#--<div class="item">-->
        <#--<img class="slide-image" src="http://placehold.it/800x300" alt="">-->
        <#--</div>-->
        <#--</div>-->
        <#--<a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">-->
        <#--<span class="glyphicon glyphicon-chevron-left"></span>-->
        <#--</a>-->
        <#--<a class="right carousel-control" href="#carousel-example-generic" data-slide="next">-->
        <#--<span class="glyphicon glyphicon-chevron-right"></span>-->
        <#--</a>-->
        <#--</div>-->
        <#--</div>-->

        <#--</div>-->

            <div class="row">

                <@m_rooms/>
            </div>

        </div>

    </div>

</div>
</#macro>
<!-- /.container -->

<@main title="Search Results"/>