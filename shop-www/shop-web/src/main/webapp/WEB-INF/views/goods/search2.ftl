
<!DOCTYPE html >
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link href="/css/common.css" rel="stylesheet" type="text/css" />
    <link href="/css/goods.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery.lazyload.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <script type="text/javascript">
        $().ready(function() {

            var $headerCart = $("#headerCart");
            var $goodsForm = $("#goodsForm");
            var $orderType = $("#orderType");
            var $pageNumber = $("#pageNumber");
            var $pageSize = $("#pageSize");
            var $gridType = $("#gridType");
            var $listType = $("#listType");
            var $size = $("#layout a.size"); // #id 标签 class
            var $previousPage = $("#previousPage");
            var $nextPage = $("#nextPage");
            var $sort = $("#sort a, #sort li");
            var $orderMenu = $("#orderMenu");
            var $startPrice = $("#startPrice");
            var $endPrice = $("#endPrice");
            var $result = $("#result");
            var $productImage = $("#result img");
            var $addCart = $("#result a.addCart");

            var layoutType = getCookie("layoutType");
            if (layoutType == "listType") {
                $listType.addClass("currentList");
                $result.removeClass("grid").addClass("list");
            } else {
                $gridType.addClass("currentGrid");
                $result.removeClass("list").addClass("grid");
            }

            $gridType.click(function() {
                var $this = $(this);
                if (!$this.hasClass("currentGrid")) {
                    $this.addClass("currentGrid");
                    $listType.removeClass("currentList");
                    $result.removeClass("list").addClass("grid");
                    addCookie("layoutType", "gridType");
                }
                return false;
            });

            $listType.click(function() {
                var $this = $(this);
                if (!$this.hasClass("currentList")) {
                    $this.addClass("currentList");
                    $gridType.removeClass("currentGrid");
                    $result.removeClass("grid").addClass("list");
                    addCookie("layoutType", "listType");
                }
                return false;
            });

            $size.click(function() {
                var $this = $(this);
                $pageNumber.val(1);
                var pageSize = $this.attr("pageSize");
                $pageSize.val(pageSize);
                $goodsForm.submit();
                return false;
            });

            $previousPage.click(function() {
                $pageNumber.val(1);
                $goodsForm.submit();
                return false;
            });

            $nextPage.click(function() {
                $pageNumber.val(2);
                $goodsForm.submit();
                return false;
            });

            $orderMenu.hover(
                    function() {
                        $(this).children("ul").show();
                    }, function() {
                        $(this).children("ul").hide();
                    }
            );

            $sort.click(function() {
                var $this = $(this);
                if ($this.hasClass("current")) {
                    $("#orderType").val("");
                } else {
                    var sort = $this.attr("orderType");
                    $("#orderType").val(sort);
                }
                $pageNumber.val(1);
                $goodsForm.submit();
                return false;
            });

            $startPrice.add($endPrice).focus(function() {
                $(this).siblings("button").show();
            });

            $startPrice.add($endPrice).keypress(function(event) {
                return (event.which >= 48 && event.which <= 57) || (event.which == 46 && $(this).val().indexOf(".") < 0) || event.which == 8 || event.which == 13;
            });

            $goodsForm.submit(function() {
                if ($orderType.val() == "" || $orderType.val() == "topDesc") {
                    $orderType.prop("disabled", true);
                }
                if ($pageNumber.val() == "" || $pageNumber.val() == "1") {
                    $pageNumber.prop("disabled", true);
                }
                if ($startPrice.val() == "" || !/^\d+(\.\d+)?$/.test($startPrice.val())) {
                    $startPrice.prop("disabled", true);
                }
                if ($endPrice.val() == "" || !/^\d+(\.\d+)?$/.test($endPrice.val())) {
                    $endPrice.prop("disabled", true);
                }
                if ($goodsForm.serializeArray().length < 1) {
                    location.href = location.pathname;
                    return false;
                }
            });

            $productImage.lazyload({
                threshold: 100,
                effect: "fadeIn"
            });

            // 加入购物车
            $addCart.click(function() {
                var $this = $(this);
                var productId = $this.attr("productId");
                $.ajax({
                    url: "/cart/add",
                    type: "POST",
                    data: {goodsId: productId, quantity: 1},
                    dataType: "json",
                    cache: false,
                    success: function(message) {
                        if (message.resultCode == 1) {
                            var $image = $this.closest("li").find("img");
                            var cartOffset = $headerCart.offset();
                            var imageOffset = $image.offset();
                            $image.clone().css({
                                width: 170,
                                height: 170,
                                position: "absolute",
                                "z-index": 20,
                                top: imageOffset.top,
                                left: imageOffset.left,
                                opacity: 0.8,
                                border: "1px solid #dddddd",
                                "background-color": "#eeeeee"
                            }).appendTo("body").animate({
                                width: 30,
                                height: 30,
                                top: cartOffset.top,
                                left: cartOffset.left,
                                opacity: 0.2
                            }, 1000, function() {
                                $(this).remove();
                            });
                            $.message('success', message.result);
                            $headerCart.find('em').html(parseInt($headerCart.find('em').html()) + 1);
                        } else {
                            $.message('error', message.resultMessage);
                        }
                    }
                });
                return false;
            });

            $.pageSkip = function(pageNumber) {
                $pageNumber.val(pageNumber);
                $goodsForm.submit();
                return false;
            }

        });
    </script>
</head>
<body>

<div class="header">
    <div class="top">
        <div class="topNav">
            <ul class="left">
                <li>
                    <span>您好，欢迎来到商HAI购</span>
                </li>
                <li id="headerLogin" class="headerLogin" style="display:block;">
                    <a href="/login">登录</a>|
                </li>
                <li id="headerRegister" class="headerRegister" style="display:block;">
                    <a href="/register">注册</a>
                </li>
            </ul>
            <ul class="right">
                <li>
                    <a href="/member/index.jhtml"  >
                        会员中心
                    </a>|
                </li>
                <li>
                    <a href="/article/list/3"  >
                        帮助中心
                    </a>|
                </li>
                <li id="headerCart" class="headerCart">
                    <a href="/cart/list">购物车</a>
                    (<em>0</em>)
                </li>
            </ul>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="span3">
                <a href="/index">
                    <img src="/upload/image/logo.gif" alt="尚HAI购" />
                </a>
            </div>
            <div class="span6">
                <div class="search">
                    <form id="goodsSearchForm" action="/goods/search" method="get">
                        <input name="keyword" class="keyword" placeholder="商品搜索" value="苹果" autocomplete="off" x-webkit-speech="x-webkit-speech" x-webkit-grammar="builtin:search" maxlength="30" />
                        <button type="submit">&nbsp;</button>
                    </form>
                </div>
                <div class="hotSearch">
                    热门搜索:
                    <a href="/goods/search?keyword=苹果">苹果</a>
                    <a href="/goods/search?keyword=三星">三星</a>
                    <a href="/goods/search?keyword=索尼">索尼</a>
                    <a href="/goods/search?keyword=华为">华为</a>
                    <a href="/goods/search?keyword=魅族">魅族</a>
                    <a href="/goods/search?keyword=佳能">佳能</a>
                    <a href="/goods/search?keyword=华硕">华硕</a>
                    <a href="/goods/search?keyword=美的">美的</a>
                    <a href="/goods/search?keyword=格力">格力</a>
                    <a href="/goods/search?keyword=小米">小米</a>

                </div>
            </div>
            <div class="span3">
                <div class="phone">
                    <em>服务电话</em>
                    800-8888888
                </div>
            </div>
        </div>
        <div class="row">
            <div class="span12">
                <dl class="mainNav">
                    <dt>
                        <a href="/product_category">所有商品分类</a>
                    </dt>
                    <dd>
                        <a href="/" >
                            首页
                        </a>
                    </dd>
                    <dd>
                        <a href="/goods/list/1" >
                            手机数码
                        </a>
                    </dd>
                    <dd>
                        <a href="/goods/list/2.jhtml" >
                            电脑办公
                        </a>
                    </dd>
                    <dd>
                        <a href="/goods/list/3.jhtml" >
                            家用电器
                        </a>
                    </dd>
                    <dd>
                        <a href="/goods/list/4.jhtml" >
                            服装鞋靴
                        </a>
                    </dd>
                    <dd>
                        <a href="/goods/list/5.jhtml" >
                            化妆护理
                        </a>
                    </dd>
                    <dd>
                        <a href="/goods/list/241.jhtml" >
                            积分商城
                        </a>
                    </dd>
                </dl>
            </div>
        </div>
    </div>
</div>
<script>
    $.post("/cart/count", {}, function (data) {
        if (data.resultCode == 1) {
            var count = data.result;
            $("#headerCart").find('em').html(count);
        }
    });
</script><div class="container goodsList">
    <div class="row">
        <div class="span2">
            <div class="hotProductCategory">
                <dl class="odd clearfix">
                    <dt>
                        <a href="/goods/list/1">手机数码</a>
                    </dt>
                    <dd>
                        <a href="/goods/list/7">手机通讯</a>
                    </dd>
                    <dd>
                        <a href="/goods/list/8">手机配件</a>
                    </dd>
                    <dd>
                        <a href="/goods/list/9">摄影摄像</a>
                    </dd>
                </dl>
                <dl class="odd clearfix">
                    <dt>
                        <a href="/goods/list/2">电脑办公</a>
                    </dt>
                    <dd>
                        <a href="/goods/list/14">电脑整机</a>
                    </dd>
                    <dd>
                        <a href="/goods/list/15">电脑配件</a>
                    </dd>
                    <dd>
                        <a href="/goods/list/16">电脑外设</a>
                    </dd>
                </dl>
                <dl class="odd clearfix">
                    <dt>
                        <a href="/goods/list/3">家用电器</a>
                    </dt>
                    <dd>
                        <a href="/goods/list/21">生活电器</a>
                    </dd>
                    <dd>
                        <a href="/goods/list/22">厨卫电器</a>
                    </dd>
                    <dd>
                        <a href="/goods/list/23">个护健康</a>
                    </dd>
                </dl>
                <dl class="odd clearfix">
                    <dt>
                        <a href="/goods/list/4">服装鞋靴</a>
                    </dt>
                    <dd>
                        <a href="/goods/list/26">品质男装</a>
                    </dd>
                    <dd>
                        <a href="/goods/list/27">时尚女装</a>
                    </dd>
                    <dd>
                        <a href="/goods/list/28">精品内衣</a>
                    </dd>
                </dl>
                <dl class="odd clearfix">
                    <dt>
                        <a href="/goods/list/5">化妆护理</a>
                    </dt>
                    <dd>
                        <a href="/goods/list/31">面部护肤</a>
                    </dd>
                    <dd>
                        <a href="/goods/list/32">身体护肤</a>
                    </dd>
                    <dd>
                        <a href="/goods/list/33">口腔护理</a>
                    </dd>
                </dl>
                <dl class="odd clearfix">
                    <dt>
                        <a href="/goods/list/6">家居家装</a>
                    </dt>
                    <dd>
                        <a href="/goods/list/36">家纺布艺</a>
                    </dd>
                    <dd>
                        <a href="/goods/list/37">家居照明</a>
                    </dd>
                    <dd>
                        <a href="/goods/list/38">家装建材</a>
                    </dd>
                </dl>
            </div>

            <div class="hotBrand clearfix">
                <dl>
                    <dt>热门品牌</dt>
                    <dd  >
                        <a href="/brand/1" title="苹果">
                            <img src="http://image.demo.shopxx.net/4.0/201501/a8275260-f9fa-4e20-8173-35b755fabb14.gif" alt="苹果" />
                            <span>苹果</span>
                        </a>
                    </dd>
                    <dd class="even" >
                        <a href="/brand/2" title="三星">
                            <img src="http://image.demo.shopxx.net/4.0/201501/8aa08a42-f5b3-4f52-bea0-5ee8bd123b0c.gif" alt="三星" />
                            <span>三星</span>
                        </a>
                    </dd>
                    <dd  >
                        <a href="/brand/3" title="索尼">
                            <img src="http://image.demo.shopxx.net/4.0/201501/dd75c116-51a7-4fbd-b014-6cf4bedcd0bb.gif" alt="索尼" />
                            <span>索尼</span>
                        </a>
                    </dd>
                    <dd class="even" >
                        <a href="/brand/4" title="华为">
                            <img src="http://image.demo.shopxx.net/4.0/201501/2a5efa56-c4cd-4984-b11a-d56cadca6cff.gif" alt="华为" />
                            <span>华为</span>
                        </a>
                    </dd>
                    <dd  >
                        <a href="/brand/5" title="魅族">
                            <img src="http://image.demo.shopxx.net/4.0/201501/72657c6c-d279-4952-ac20-1abcff776b07.gif" alt="魅族" />
                            <span>魅族</span>
                        </a>
                    </dd>
                    <dd class="even" >
                        <a href="/brand/6" title="佳能">
                            <img src="http://image.demo.shopxx.net/4.0/201501/081d4e29-b631-4a49-8672-792a1308ce97.gif" alt="佳能" />
                            <span>佳能</span>
                        </a>
                    </dd>

                </dl>
            </div>

            <div class="hotGoods">
                <dl>
                    <dt>热销商品</dt>
                    <dd>
                        <a href="/goods/content/1">
                            <img src="http://image.demo.shopxx.net/4.0/201501/e39f89ce-e08a-4546-8aee-67d4427e86e2-thumbnail.jpg" alt="苹果 iPhone 5s" />
                            <span title="苹果 iPhone 5s">苹果 iPhone 5s111</span>
                        </a>
                        <strong>
                            ￥4200
                            <del>￥5040</del>
                        </strong>
                    </dd>
                    <dd>
                        <a href="/goods/content/2">
                            <img src="http://image.demo.shopxx.net/4.0/201501/d7f59d79-1958-4059-852c-0d6531788b48-thumbnail.jpg" alt="苹果 iPhone 6" />
                            <span title="苹果 iPhone 6">苹果 iPhone 6111</span>
                        </a>
                        <strong>
                            ￥5200
                            <del>￥6240</del>
                        </strong>
                    </dd>
                    <dd>
                        <a href="/goods/content/3">
                            <img src="http://image.demo.shopxx.net/4.0/201501/031e30a4-6237-4650-a14c-5132aa126acd-thumbnail.jpg" alt="三星 G3818" />
                            <span title="三星 G3818">三星 G3818111</span>
                        </a>
                        <strong>
                            ￥1200
                            <del>￥1440</del>
                        </strong>
                    </dd>

                </dl>
            </div>
            <div class="hotPromotion">
                <dl>
                    <dt>热销促销</dt>
                    <dd>
                        <a href="/promotion/1" title="iPhone促销专场">
                            <img src="http://image.demo.shopxx.net/4.0/201501/0a1ceb47-f51c-4dfb-9d51-cb723c2f8e78.jpg" alt="iPhone促销专场" />
                        </a>
                    </dd>
                    <dd>
                        <a href="/promotion/2" title="联想笔记本促销专场">
                            <img src="http://image.demo.shopxx.net/4.0/201501/98229d3b-08b7-4888-a99e-cf21a2a03b65.jpg" alt="联想笔记本促销专场" />
                        </a>
                    </dd>
                    <dd>
                        <a href="/promotion/3" title="平板电视促销专场">
                            <img src="http://image.demo.shopxx.net/4.0/201501/2b71bacf-bd18-46fb-adab-072dd544ed66.jpg" alt="平板电视促销专场" />
                        </a>
                    </dd>

                </dl>
            </div>
        </div>
        <div class="span10">
            <div class="breadcrumb">
                <ul>
                    <li>
                        <a href="/index">首页</a>
                    </li>
                    <li>搜索 &quot;苹果&quot; 结果列表</li>

                </ul>
            </div>
            <form id="goodsForm" action="/goods/search" method="get">
                <input type="hidden" id="keyword" name="keyword" value="苹果" />
                <input type="hidden" id="orderType" name="sort" value="id.desc" />
                <input type="hidden" id="pageNumber" name="page" value="1" />
                <input type="hidden" id="pageSize" name="pageSize" value="2" />
                <div class="bar">
                    <div id="layout" class="layout">
                        <label>布局:</label>
                        <a href="javascript:;" id="gridType" class="gridType">
                            <span>&nbsp;</span>
                        </a>
                        <a href="javascript:;" id="listType" class="listType">
                            <span>&nbsp;</span>
                        </a>
                        <label>数量:</label>
                        <a href="javascript:;" class="size" pageSize="20">
                            <span>20</span>
                        </a>
                        <a href="javascript:;" class="size" pageSize="40">
                            <span>40</span>
                        </a>
                        <a href="javascript:;" class="size " pageSize="80">
                            <span>80</span>
                        </a>
                        <span class="page">
								<label>共9个商品 1/5</label>
                                    <a href="javascript:;" id="nextPage" class="nextPage">
                                        <span>下一页</span>
                                    </a>
							</span>
                    </div>
                    <div id="sort" class="sort">
                        <div id="orderMenu" class="orderMenu">
                            <span></span>
                            <ul>
                                <li orderType="is_top.desc">置顶降序</li>
                                <li orderType="price.asc">价格升序</li>
                                <li orderType="price.desc">价格降序</li>
                                <li orderType="sales.desc">销量降序</li>
                                <li orderType="score.desc">评分降序</li>
                                <li orderType="create_date.desc">日期降序</li>
                            </ul>
                        </div>
                        <a href="javascript:;" class="asc" orderType="price.asc">价格</a>
                        <a href="javascript:;" class="desc" orderType="sales.desc">销量</a>
                        <a href="javascript:;" class="desc" orderType="score.desc">评分</a>
                        <input type="text" id="startPrice" name="startPrice" class="startPrice" value="" maxlength="16" title="价格过滤最低价格" onpaste="return false" />
                        <label>-</label>
                        <input type="text" id="endPrice" name="endPrice" class="endPrice" value="" maxlength="16" title="价格过滤最高价格" onpaste="return false" />
                        <button type="submit">确 定</button>
                    </div>
                </div>
                <div id="result" class="result grid clearfix">
                    <ul>
                        <li>
                            <a href="/goods/content/47">
                                <img src="/upload/image/blank.gif" data-original="http://image.demo.shopxx.net/4.0/201501/936b1088-e222-47d1-af6f-a4360a05ffde-thumbnail.jpg" />
                                <div>
                                    <span title="苹果 iPhone 5s Case 保护套">苹果 iPhone 5s Case 保护套</span>
                                    <em title="原装品质，精雕细琢">原装品质，精雕细琢</em>
                                </div>
                            </a>
                            <strong>
                                ￥0
                                <del>￥288</del>
                            </strong>
                            <div class="action">
                                <a href="javascript:;" class="addCart" productId="47">加入购物车</a>
                            </div>
                        </li>
                        <li>
                            <a href="/goods/content/34">
                                <img src="/upload/image/blank.gif" data-original="http://image.demo.shopxx.net/4.0/201501/62142fec-eae0-4881-abc6-04ecb2afcbad-thumbnail.jpg" />
                                <div>
                                    <span title="苹果 iPad mini3 MGY92CH">苹果 iPad mini3 MGY92CH</span>
                                    <em title="指纹识别，Retina显示屏">指纹识别，Retina显示屏</em>
                                </div>
                            </a>
                            <strong>
                                ￥2888
                                <del>￥3465</del>
                            </strong>
                            <div class="action">
                                <a href="javascript:;" class="addCart" productId="34">加入购物车</a>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="pagination">
                    <span class="firstPage" >&nbsp;</span>

                    <span class="previousPage">&nbsp;</span>
                    <span class="currentPage">1</span>

                    <a href="javascript: $.pageSkip(2);">2</a>

                    <a href="javascript: $.pageSkip(3);">3</a>

                    <a href="javascript: $.pageSkip(4);">4</a>

                    <a href="javascript: $.pageSkip(5);">5</a>

                    <a href="javascript: $.pageSkip(2);" class="nextPage">&nbsp;</a>

                    <a href="javascript: $.pageSkip(5);" class="lastPage">&nbsp;</a>

                </div>

            </form>
        </div>
    </div>
</div>
<div class="footer">
    <div class="service clearfix">
        <dl>
            <dt class="icon1">新手指南</dt>
            <dd>
                <a href="#">购物流程</a>
            </dd>
            <dd>
                <a href="#">会员注册</a>
            </dd>
            <dd>
                <a href="#">购买宝贝</a>
            </dd>
            <dd>
                <a href="#">支付货款</a>
            </dd>
            <dd>
                <a href="#">用户协议</a>
            </dd>
        </dl>
        <dl>
            <dt class="icon2">特色服务</dt>
            <dd>
                <a href="#">购物流程</a>
            </dd>
            <dd>
                <a href="#">会员注册</a>
            </dd>
            <dd>
                <a href="#">购买宝贝</a>
            </dd>
            <dd>
                <a href="#">支付货款</a>
            </dd>
            <dd>
                <a href="#">用户协议</a>
            </dd>
        </dl>
        <dl>
            <dt class="icon3">支付方式</dt>
            <dd>
                <a href="#">购物流程</a>
            </dd>
            <dd>
                <a href="#">会员注册</a>
            </dd>
            <dd>
                <a href="#">购买宝贝</a>
            </dd>
            <dd>
                <a href="#">支付货款</a>
            </dd>
            <dd>
                <a href="#">用户协议</a>
            </dd>
        </dl>
        <dl>
            <dt class="icon4">配送方式</dt>
            <dd>
                <a href="#">购物流程</a>
            </dd>
            <dd>
                <a href="#">会员注册</a>
            </dd>
            <dd>
                <a href="#">购买宝贝</a>
            </dd>
            <dd>
                <a href="#">支付货款</a>
            </dd>
            <dd>
                <a href="#">用户协议</a>
            </dd>
        </dl>
        <div class="qrCode">
            <img src="/images/qr_code.gif" alt="官方微信" />
            官方微信
        </div>
    </div>
    <div class="bottom">
        <div class="bottomNav">
            <ul>
            </ul>
        </div>
        <div class="info">
            <p>湘ICP备10000000号</p>
            <p>Copyright © 2005-2015 尚HAI购 版权所有</p>
            <ul>
                <li>
                    <a href="http://www.shopxx.net" target="_blank">
                        <img src="http://image.demo.shopxx.net/4.0/201501/1c675feb-e488-4fd5-a186-b28bb6de445a.gif" alt="SHOP++" />
                    </a>
                </li>
                <li>
                    <a href="http://www.alipay.com" target="_blank">
                        <img src="http://image.demo.shopxx.net/4.0/201501/ae13eddc-25ac-427a-875d-d1799d751076.gif" alt="支付宝" />
                    </a>
                </li>
                <li>
                    <a href="http://www.tenpay.com" target="_blank">
                        <img src="http://image.demo.shopxx.net/4.0/201501/adaa9ac5-9994-4aa3-a336-b65613c85d50.gif" alt="财付通" />
                    </a>
                </li>
                <li>
                    <a href="https://www.95516.com" target="_blank">
                        <img src="http://image.demo.shopxx.net/4.0/201501/41c18c8d-f69a-49fe-ace3-f16c2eb07983.gif" alt="中国银联" />
                    </a>
                </li>
                <li>
                    <a href="http://www.kuaidi100.com" target="_blank">
                        <img src="http://image.demo.shopxx.net/4.0/201501/ea46ca0a-e8f0-4e2c-938a-5cb19a07cb9a.gif" alt="快递100" />
                    </a>
                </li>
                <li>
                    <a href="http://www.cnzz.com" target="_blank">
                        <img src="http://image.demo.shopxx.net/4.0/201501/e12f226b-07f9-4895-bcc2-78dbe551964b.gif" alt="站长统计" />
                    </a>
                </li>
                <li>
                    <a href="http://down.admin5.com" target="_blank">
                        <img src="http://image.demo.shopxx.net/4.0/201501/fd9d6268-e4e2-41f6-856d-4cb8a49eadd1.gif" alt="A5下载" />
                    </a>
                </li>
                <li>
                    <a href="http://www.ccb.com" target="_blank">
                        <img src="http://image.demo.shopxx.net/4.0/201501/6c57f398-0498-4044-80d8-20f6c40d5cef.gif" alt="中国建设银行" />
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>