<html>
    <head>

    </head>
    <body>
        <div>
            真实姓名：${realName} <br/>
            userId：${userId} <br/>
            isMan：${isMan} <br/>
            性別：<#if isMan >男<#else>女</#if><br/>
            性別：[#if isMan ]男[#else]女[/#if]<br/>
            createDate：${createDate?datetime} <br/>
            createDate：${createDate?date} <br/>
            createDate：${createDate?time} <br/>
        </div>
    </body>
</html>