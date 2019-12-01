<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить новое соревнование
    </a>

    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data" action="/addcompetition">
                <div class="form-group">
                    <input type="text" class="form-control" name="nameCompetition" placeholder="Название соревнования" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="sport" placeholder="Спорт">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="competitionTime" placeholder="Время">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="result" placeholder="Результат">
                </div>

                <select name="stage" class="form-control" value="" required>-->
                    <option></option>
                    <option value="">none</option>
                    <#list arenas as arena>
                        <option value ="${arena.id}">${arena.nameArena}</option>
                    </#list>
                </select>

                <select name="opponents" class="form-control" value="" required multiple>-->
                    <option></option>
                    <option value="">none</option>
                    <#list teams as team>
                        <option value ="${team.id}">${team.nameTeam}</option>
                    </#list>
                </select>


                <input type="hidden" name="_csrf" value="${_csrf.token}">

                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>
    </div>

    <h3>Список соревнований</h3>
    <table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Название соревнования</th>
        <th scope="col">Спорт</th>
        <th scope="col">Время</th>
        <th scope="col">Результат</th>
        <th scope="col">Арена</th>
        <th scope="col">Команды</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <#list competitions as competition>
        <div>
            <th scope="row">${competition.id}</th>
            <td>${competition.nameCompetition}</td>
            <td>${competition.sport}</td>
            <td>${competition.competitionTime}</td>
            <td>${competition.result}</td>
            <td>${competition.nameStage}</td>
            <td><#list competition.opponents as opponent>${opponent.nameTeam}<#sep>,</#sep>
                <#else>
                    No teams
                </#list></td>
            <td><a class="btn btn-primary" href="/competition/${competition.id}" role="button">Редактировать</a></td>
            <td><a class="btn btn-primary" href="/competitiondel/${competition.id}" role="button">Удалить</a></td>
        </div>
    </#list>
</@c.page>