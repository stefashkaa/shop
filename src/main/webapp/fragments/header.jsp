<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="top">
  <div class="container">
    <div class="col-sm-6 col-sm-offset-6">
      <ul class="menu">
        <c:choose>
          <c:when test="${empty user}">
            <li><a href="login.html">Login</a></li>
            <li><a href="register.html">Register</a></li>
            </c:when>
            <c:otherwise>
            <li><a href="index.html">Hello, ${user.name}</a></li>
            <li><a href="logout.html">Logout</a></li>
            </c:otherwise>
          </c:choose>
      </ul>
    </div>
  </div>
</div>

<div class="navbar navbar-default yamm" role="navigation" id="navbar">
  <div class="container">
    <div class="navbar-header">

      <a class="navbar-brand home" href="index.html" data-animate-hover="bounce">
        <img src="static/images/logo.png" alt="Online shop logo" class="hidden-xs" />
        <img src="static/images/logo-small.png" alt="Online shop logo" class="visible-xs" />
        <span class="sr-only">Online shop</span>
      </a>

      <div class="navbar-buttons">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation">
          <span class="sr-only">Toggle navigation</span>
          <i class="fa fa-align-justify"></i>
        </button>
        <button type="button" id="btnSearch" class="navbar-toggle" data-toggle="collapse" data-target="#search">
          <span class="sr-only">Toggle search</span>
          <i class="fa fa-search"></i>
        </button>
        <a class="btn btn-default navbar-toggle" href="cart.html?action=view">
          <i class="fa fa-shopping-cart"></i>  
          <span class="hidden-xs">
            <c:choose>
              <c:when test="${empty cart}">0 item in cart</c:when>
              <c:otherwise>${cart.count} items in cart</c:otherwise>
            </c:choose>
          </span>
        </a>
      </div>
    </div>

    <div class="navbar-collapse collapse" id="navigation">
      <ul class="nav navbar-nav navbar-left">
        <li><a class="active" href="index.html">Home</a></li>
        <li><a href="cart.html?action=view">Your cart</a></li>
        <li><a href="checkout.html">Checkout</a></li>
      </ul>
    </div>

    <div class="navbar-buttons">

      <div class="navbar-collapse collapse right" id="basket-overview">
        <a href="cart.html?action=view" class="btn btn-primary navbar-btn">
          <i class="fa fa-shopping-cart"></i>
          <span class="hidden-sm">
            <c:choose>
              <c:when test="${empty cart}">0 item in cart</c:when>
              <c:otherwise>${cart.count} items in cart</c:otherwise>
            </c:choose>
          </span>
        </a>
      </div>

      <div class="navbar-collapse collapse right" id="search-not-mobile">
        <form class="navbar-form" action="search.html" method="GET">
        <div class="input-group">
          <input type="text" class="form-control" name="keyword" placeholder="Search" />
          <span class="input-group-btn">
            <button type="submit" name="btnSearch" class="btn btn-primary">
              <i class="fa fa-search"></i>
            </button>
          </span>
        </div>
      </form>
      </div>

    </div>
  </div>
</div>