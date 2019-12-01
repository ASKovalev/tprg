<#import "parts/common.ftlh" as c>

<@c.page>
<h4>Пользователи</h4>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Имя пользователя</th>
        <th scope="col">Роль</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.username}</td>
        <td><#list user.roles as role>${role}<#sep>, </#list></td>
        <td><a class="btn btn-primary" href="/user/${user.id}" role="button">Редактировать</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>