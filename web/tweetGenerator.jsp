<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Tweet Generator</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <style>
        .highlight {
            padding: 9px 14px;
            margin-bottom: 14px;
            background-color: #f7f7f9;
            border: 1px solid #e1e1e8;
            border-radius: 4px;
        }
    </style>
    <body id="page-top">

        <nav class="navbar navbar-default navbar-custom navbar-fixed-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header page-scroll">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        Menu <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand" href="/">Tweet Generator</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="/team">Team</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>


        <div class="container" style="margin-top: 70px;">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="post-preview">
                        <form action="tweet-generator" method="POST">
                            <label for="exampleInputEmail1">Paste the twitter handles below</label>
                            <input type="text" name="twitterHandles" class="form-control" placeholder="Twitter Handles..">
                            <input type="submit" class="btn btn-default" value="Submit" style="margin-top: 1em;">
                        </form>

                        <c:if test='<%= request.getAttribute("distinctTwitterHandles") != null%>'>
                            <h3>Non Duplicated Twitter Handles</h3>
                            <figure class="highlight">
                                <c:forEach items='<%= (request.getAttribute("distinctTwitterHandles"))%>' var='handle'>
                                    ${handle} &nbsp;
                                </c:forEach>
                            </figure>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>



    </body>
</html>


