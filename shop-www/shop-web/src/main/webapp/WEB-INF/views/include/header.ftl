<div class="header">
    <div class="top">
        <div class="topNav">
            <ul class="left">
                <li>
                    <span>您好，欢迎来到商HAI购</span>
                </li>
                <li id="headerLogin" class="headerLogin">
                    <a href="/login">登录</a>|
                </li>
                <li id="headerRegister" class="headerRegister">
                    <a href="/register">注册</a>
                </li>
            </ul>
            <ul class="right">
            [@navigation_list position = 0]
                [#list navigations as navigation]
                    <li>
                        <a href="${navigation.url}" [#if navigation.isBlankTarget()]target = "_blank"[/#if] >
                        ${navigation.name}
                        </a>|
                    </li>
                [/#list]
            [/@navigation_list]

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
                <a href="${ctx}/index">
                    <img src="${ctx}/upload/image/logo.gif" alt="尚HAI购" />
                </a>
            </div>
            <div class="span6">
                <div class="search">
                    <form id="goodsSearchForm" action="${ctx}/goods/search" method="get">
                        <input name="keyword" class="keyword" value="" placeholder="商品搜索" autocomplete="off" x-webkit-speech="x-webkit-speech" x-webkit-grammar="builtin:search" maxlength="30" />
                        <button type="submit">&nbsp;</button>
                    </form>
                </div>
                <div class="hotSearch">
                    热门搜索:
                [@hot_search_keywords]
                    [#list keywords as keyword]
                        <a href="${ctx}/goods/search?keyword=${keyword}">${keyword}</a>
                    [/#list]
                [/@hot_search_keywords]

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
                        <a href="${ctx}/index">所有商品分类</a>
                    </dt>
                [@navigation_list position = 1]
                    [#list navigations as navigation]
                        <dd>
                            <a href="${ctx}${navigation.url}" >
                            ${navigation.name}
                            </a>
                        </dd>
                    [/#list]
                [/@navigation_list]
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
</script>