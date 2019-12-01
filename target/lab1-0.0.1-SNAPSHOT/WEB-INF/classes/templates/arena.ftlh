<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>
        <@l.logout />
    </div>
    <div>
        <form method="post" action="/addarena">
            <input required type="text" name="nameArena" placeholder="Название" />
            <input type="text" name="numberOfSeats" placeholder="Вместимость">
            <input type="text" name="freeSpace" placeholder="Свободные места">
            <input type="text" name="costTicket" placeholder="Цена билета">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit">Добавить</button>
        </form>
    </div>
    <div>Список арен</div>
    <#list arenas as arena>
        <div>
            <b>${arena.id}</b>
            <span>${arena.nameArena}</span>
            <i>${arena.numberOfSeats}</i>
            <strong>${arena.freeSpace}</strong>
            <strong>${arena.costTicket}</strong>
            <td><a href="/arena/${arena.id}">edit</a></td>
            <td><a href="/arenadel/${arena.id}">delete</a> </td>
        </div>
    <#else>
        No arenas
    </#list>
</@c.page>