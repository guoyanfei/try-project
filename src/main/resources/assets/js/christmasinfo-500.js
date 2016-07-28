$.ajax({
    url:'/Christmas/ajaxIsShowChristmas',
    type:'post',
    success:function(data){
        if(data.isShow) {
            $('head').prependTo('<style>.slowWalk{-webkit-animation-name:christmas;-webkit-animation-duration:1s;-webkit-animation-iteration-count:infinite;-webkit-animation-timing-function:steps(1,start);-moz-animation-name:christmas;-moz-animation-duration:1s;-moz-animation-iteration-count:infinite;-moz-animation-timing-function:steps(1,start)}.christmasPosition{width:75px;height:75px;position:fixed;right:0;bottom:120px;overflow:hidden;z-index:999;opacity:1;background:url("http://yun.dui88.com/webapp/img/christmasMan1.png") 0 0 no-repeat;background-size:150px auto}@-webkit-keyframes christmas{0%{background-position:0 0}50%{background-position:-75px 0}100%{background-position:0 0}}@-moz-keyframes christmas{0%{background-position:0 0}50%{background-position:-75px 0}100%{background-position:0 0}}</style>');
            $('body').prependTo('<a href="/Christmas/index" class="christmasPosition slowWalk"></a>');
        }
    }

})
