<#include "main.ftl">

<#macro m_body>
<div class="page-header text-center"><h1>Search Results</h1></div>
<div class="container">
    <div class="col-lg-10 col-lg-offset-1">
        <#if rooms?has_content>
            <#list roomTypes as room>
                <div class="col-sm-4 col-lg-4 col-md-4">
                    <div class="thumbnail">
                        <img class="room_img_preview" src="/images/hotels/rooms/${(room.photos)[0].path} " alt="">
                        <div class="caption">
                            <h4><a href="/search/results/room/${room.id}">${room.title}</a>
                            </h4>
                            <p> ${(room.description?split("."))[0]}</p>
                        </div>
                        <div class="ratings">
                            <h4 class="pull-right"><b>$${room.price*days}</b></h4>
                        <#--<p class="pull-right">15 reviews</p>-->
                            <p>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                            </p>
                        </div>
                    </div>
                </div>

            </#list>
        <#else >
            <div class="page-header">
                <h3>Soory, we don't have available rooms, that suits your search</h3>
                <p>try different dates</p>
            </div>
        </#if>
    </div>
</div>
</#macro>

<@main title="Search Results"/>