<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <h3>Каталог соревнований</h3>
    <table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Название соревнования</th>
        <th scope="col">Вид спорта</th>
        <th scope="col">Дата</th>
        <th scope="col">Результат</th>
        <th scope="col">Арена</th>
        <th scope="col">Команды</th>
        <th scope="col">Свободные места</th>
        <th scope="col">Цена билета</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <#list competitions as competition>
        <div>
            <td>${competition.nameCompetition}</td>
            <td>${competition.sport}</td>
            <td>${competition.competitionTime}</td>
            <td>${competition.result}</td>
            <td>${competition.nameStage}</td>
            <td><#list competition.opponents as opponent>${opponent.nameTeam}<#sep>,</#sep>
                <#else>
                    Unknown
                </#list></td>
            <td>${competition.spaceStage}</td>
            <td>${competition.costStage}</td>
            <td><a class="btn btn-primary" href="/catalog/${competition.idStage}" role="button">Купить</a></td>
        </div>
    </#list>
</@c.page>