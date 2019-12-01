<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.isAdmin()
    f = true
    >
<#else>
    <#assign
    f = false
    name = "Guest"
    isAdmin = false
    >
</#if>