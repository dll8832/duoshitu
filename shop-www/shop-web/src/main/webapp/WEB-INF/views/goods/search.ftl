<!DOCTYPE html >
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/css/goods.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.lazyload.js"></script>
    <script type="text/javascript" src="${ctx}/js/common.js"></script>
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

[#include "include/header.ftl"]

<div class="container goodsList">
    <div class="row">
        <div class="span2">
            <div class="hotProductCategory">
            [#--根级分类展示--]
            [@product_category_root_list]
                [#list productCategories as productCategory]
                    <dl class="odd clearfix">
                        <dt>
                            <a href="${ctx}/goods/list/${productCategory.id}">${productCategory.name}</a>
                        </dt>

                        [@product_category_children_list parentId = productCategory.id ]
                            [#list productCategories as productCategory]
                                <dd>
                                    <a href="${ctx}/goods/list/${productCategory.id}">${productCategory.name}</a>
                                </dd>
                            [/#list]
                        [/@product_category_children_list]
                    </dl>
                [/#list]
            [/@product_category_root_list]

            </div>

            <div class="hotBrand clearfix">
                <dl>
                    <dt>热门品牌</dt>
                    [@brand_list count=6]
                        [#list brands as brand]
                            <dd [#if (brand_index + 1) % 2 ==0 ]class="even"[/#if] >
                                <a href="${ctx}/brand/${brand.id}" title="${brand.name}">
                                    <img src="${brand.logo}" alt="${brand.name}" />
                                    <span>${brand.name}</span>
                                </a>
                            </dd>
                        [/#list]
                    [/@brand_list]
                </dl>
            </div>

            <div class="hotGoods">
                <dl>
                    <dt>热销商品</dt>
                    [@goods_list count=3]
                        [#list goods as good ]
                            <dd>
                                <a href="${ctx}/goods/detail/${good.id}" title="${good.name}">
                                    <img src="${good.image}" alt="${good.name}" />
                                    <span title="${good.name}">${good.name}</span>
                                </a>
                                <strong>
                                    ￥${good.price}
                                    <del>￥${good.marketPrice}</del>
                                </strong>
                            </dd>
                        [/#list]
                    [/@goods_list]
                </dl>
            </div>

            <div class="hotPromotion">
                <dl>
                    <dt>热销促销</dt>
                    [@promotion_list count=3]
                        [#if promotions?has_content]
                            [#list promotions as promotion ]
                                <dd>
                                    <a href="${ctx}/promotion/${promotion.id}" title="${promotion.name}">
                                        <img src="${promotion.image}" alt="${promotion.name}" />
                                    </a>
                                </dd>
                            [/#list]
                        [/#if]
                    [/@promotion_list]

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

[#include "include/footer.ftl"]
</body>
</html>