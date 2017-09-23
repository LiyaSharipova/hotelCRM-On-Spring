<#include "main.ftl"/>


<#macro m_body>
<header id="myCarousel" class="carousel slide">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for Slides -->
    <div class="carousel-inner">
        <div class="item active">
            <!-- Set the first background image using inline CSS below. -->

            <div class="fill" style="background-image:url('/images/hotels/hotel_main.jpg');"></div>
            <div class="carousel-caption">
            <#--<h2>Caption 1</h2>-->
            </div>
        </div>
        <div class="item">
            <!-- Set the second background image using inline CSS below. -->
            <div class="fill" style="background-image:url('/images/hotels/lobby.jpg');"></div>
            <div class="carousel-caption">
            <#--<h2>Caption 2</h2>-->
            </div>
        </div>
        <div class="item">
            <!-- Set the third background image using inline CSS below. -->
            <div class="fill" style="background-image:url('/images/hotels/room_main.JPG');"></div>
            <div class="carousel-caption">
            <#--<h2>Caption 3</h2>-->
            </div>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
        <span class="icon-prev"></span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
        <span class="icon-next"></span>
    </a>

</header>

<div class="container">
    <div class="row">
        <div class="col-lg-12">


            <h1>The Fullerton Hotel</h1>
            <h4>The Fullerton Hotel Singapore is a unique masterpiece combining the best of the past and present.
                Experience
                heritage, luxury and the finest Singapore has to offer with our latest specials.</h4>
        </div>

        <#include "bookingSearch.ftl"/>

    </div>
</div>
</#macro>
<@main title="Home"/>
