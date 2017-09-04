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
            <img src="${ctx}/images/qr_code.gif" alt="官方微信" />
            官方微信
        </div>
    </div>
    <div class="bottom">
        <div class="bottom">
            <div class="bottomNav">
                <ul>
                [@navigation_list position=2]
                    [#list navigations as navigation]
                        <li>
                            <a href="${navigation.url}">${navigation.name}</a>
                            [#if navigation_has_next]|[/#if]
                        </li>
                    [/#list]
                [/@navigation_list]


                </ul>
            </div>
            <div class="info">
                <p>湘ICP备10000000号</p>
                <p>Copyright © 2005-2017尚HAI购商城 版权所有</p>
                <ul>
                [@friend_link_list ]
                    [#list friendLinks as friendLink]
                        <li>
                            <a href="${friendLink.url}" target="_blank">
                                <img src="${friendLink.logo}" alt="${friendLink.name}">
                            </a>
                        </li>
                    [/#list]
                [/@friend_link_list]

                </ul>
            </div>
        </div>
    </div>
</div>