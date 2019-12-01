<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить новую команду
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data" action="/addteam">

                <div class="form-group">
                    <input type="text" class="form-control" name="nameTeam" placeholder="Название" />
                </div>

                <div class="form-group">
                    <input type="text" class="form-control" name="coach" placeholder="Тренер">
                </div>

                <div class="form-group">
                    <select class="form-control" name="tournaments" value="" required multiple>
                        <option></option>
                        <option value="">none</option>
                        <#list competitions as competition>
                            <option value ="${competition.id}">${competition.nameCompetition}</option>
                        </#list>
                    </select>
                </div>

                <input type="hidden" name="_csrf" value="${_csrf.token}">

                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>
    </div>

    <h3>Список команд</h3>
    <table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Название</th>
        <th scope="col">Тренер</th>
        <th scope="col">Состав</th>
        <th scope="col">Соревнования</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <#list teams as team>
        <tr>
            <th scope="row">${team.id}</th>
            <td>${team.nameTeam}</td>
            <td>${team.coach}</td>
            <td><#list team.person as person>${person.name}<#sep>,</#sep>
                <#else>
                    No athelete
                </#list></td>
            <td><#list team.tournaments as tournament>${tournament.nameCompetition}<#sep>,</#sep>
                <#else>
                    No competition
                </#list></td>

            <td><a class="btn btn-primary" href="/team/${team.id}" role="button">Редактировать</a></td>
            <td><a class="btn btn-primary" href="/teamdel/${team.id}" role="button">Удалить</a></td>

        </tr>
    </#list>
</@c.page>