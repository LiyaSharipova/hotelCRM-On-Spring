<#include "main.ftl">
<@main title="Room Data Page"/>
<#macro m_body>
<div class="page-header text-center"><h1>${room.title}</h1></div>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <#if error ??>
                <div class="alert alert-danger">
                ${error}
                </div>

            </#if>
            <h3 class="lead"><b>Description</b></h3>
            <h4>${room.description}</h4>
            <h4><span class="glyphicon glyphicon-user"></span>Adults ${room.adults}
                <span class="glyphicon glyphicon-user"></span>Kids ${room.kids}</h4>
            <#if bookingForm ??>
                <p><i>Do you like this room? Book it now! Already booked dates are disabled.</i></p>
                <#if disableDays ??>
                    <script type="text/javascript">
                        var disabledays = [<#list disableDays as day>'${day}',</#list>]
                    </script>
                </#if>
                <#include "bookingForRoom.ftl">

            <#else>
                <ul>
                    <li>Check in: ${checkIn}</li>
                    <li>Check out: ${checkOut}</li>
                    <li class="ratings">Price: $${room.price*days}</li>
                </ul>
                <form action="" method="post">
                    <button type="submit" id="roomSearchBtn" class="btn btn-success">Book</button>
                </form>

            </#if>
        </div>
        <div class="col-md-8">

            <div class="row carousel-holder">

                <div class="col-md-12">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <#list room.photos as photo>
                                <#if photo_index==0>
                                    <li data-target="#carousel-example-generic" data-slide-to="${photo_index}"
                                        class="active"></li>
                                <#else>
                                    <li data-target="#carousel-example-generic" data-slide-to="${photo_index}"></li>
                                </#if>
                            </#list>
                        </ol>
                        <div class="carousel-inner">
                            <#list room.photos as photo>
                                <#if photo_index==0>
                                <div class="item active">
                                <#else>
                                <div class="item">
                                </#if>
                                <img class="slide-image" src="/images/hotels/rooms/${photo.path}" alt="">
                            </div>
                            </#list>
                        </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</#macro>