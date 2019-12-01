<#import "parts/common.ftlh" as c>

<@c.page>
    <h4>Редактирование пользователей</h4>

    <form action="/user" method="post" enctype="multipart/form-data">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Имя пользователя : </label>
            <div class="form-group col-sm-10">
                <input type="text" name="username" class="form-control" value="${user.username}">
            </div>
        </div>
        <div class="form-group row">
        <#list roles as role>
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>
                        <label class="form-check-label" for="gridCheck1">${role}</label>
                    </div>
                </div>
        </#list>
        </div>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit" class="btn btn-primary">Сохранить</button>
    </form>
</@c.page>