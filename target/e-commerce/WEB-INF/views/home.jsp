<%@include file="/WEB-INF/views/template/header.jsp" %>



<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide home-image"
                 src="<c:url value="/resources/images/pic3.jpg" />"
                 alt="First slide">

            <div class="container">
                <div class="carousel-caption">
                    <h1>Welcome to Online Shopping</h1>

                    <p>Your SuperMarket At Home!</p>

                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide home-image"
                 src="<c:url value="/resources/images/pic1.jpg" />"
                 alt="Second slide">

            <div class="container">
                <div class="carousel-caption">
                    <h1>Shopping Just Got Easier</h1>

                    <p>Home Needs Delivered With a Click of a Button</p>

                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide home-image"
                 src="<c:url value="/resources/images/pic2.jpg" />"
                 alt="Third slide">

            <div class="container">
                <div class="carousel-caption">
                    <h1>All We Need Is Your Credit Card Info</h1>

                    <p>Provide Your Credit Card and Delivery Info And You Are All Set</p>

                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=Food" />"
               role="button">
                <img class="img-circle" src="<c:url value="/resources/images/food.jpg" />" alt="Food
                Image" width="140" height="140"></a>

            <h2>Food</h2>
            <p>You are one click away from your favorite food.</p>

        </div><!-- /.col-lg-4 -->



    <div class="row">
        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=Drink" />"
               role="button">
                <img class="img-circle" src="<c:url value="/resources/images/drinks.jpg" />" alt="Drink
                Image" width="140" height="140"></a>

            <h2>Drinks</h2>
            <p>A one stop shop for all your favorite drinks.</p>

        </div><!-- /.col-lg-4 -->

    <div class="row">
        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=Fruits" />"
               role="button">
                <img class="img-circle" src="<c:url value="/resources/images/fruits.jpg" />" alt="Fruit
                Image" width="140" height="140"></a>

            <h2>Fruits and Vegetables</h2>
            <p>Get your vitamins fresh from the farm.</p>

        </div><!-- /.col-lg-4 -->


    </div><!-- /.row -->

    <%@include file="/WEB-INF/views/template/footer.jsp" %>

