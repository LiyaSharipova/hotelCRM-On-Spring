<#include "rooms.ftl">
<#macro m_header>
    <#if class=="standart">
    Standart Rooms
    <#elseif class=="lux">
    Lux Rooms
    <#else>Apartments
    </#if>
</#macro>

<#macro m_rooms>
    <#list rooms as room>
    <#--<#assign photos = ${roomType.photos}></#assign>-->
    <div class="col-sm-4 col-lg-4 col-md-4">
        <div class="thumbnail">
            <img class="room_img_preview" src="/images/hotels/rooms/${(room.photos)[0].path} " alt="">
            <div class="caption">
                <h4><a href="${room.id}">${room.title}</a>
                </h4>
                <p> ${(room.description?split("."))[0]}</p>
            </div>
            <div class="ratings">
                <h4 class="pull-right"><b>$${room.price}</b></h4>
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
</#macro>