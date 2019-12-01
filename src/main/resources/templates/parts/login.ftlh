<#include "security.ftlh">
<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Имя пользователя : </label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="User name"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Пароль : </label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="Password"/> </label>
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <#if !isRegisterForm>
            <a class="btn btn-primary" href="/registration" role="button">Регистрация</a>
        </#if>
        <button class="btn btn-primary" type="submit"><#if isRegisterForm>Create<#else>Войти</#if></button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <#if f == true>
            <input type="submit" class="btn btn-primary" value="Выйти"/>
            <#else>
                <input type="submit" class="btn btn-primary" value="Войти"/>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
</#macro>