<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить нового спортсмена
    </a>
    <div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data" action="/addathelete">
            <div class="form-group">
                <input type="text" class="form-control" name="name" placeholder="Имя" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="surname" placeholder="Фамилия">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="patronymic" placeholder="Отчество">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="biography" placeholder="Биография">
            </div>
            <div class="form-group">
            <select class="form-control" name="club" value="" required>-->
                                <option></option>
                                <option value="">none</option>
                                <#list teams as team>
                                    <option value ="${team.id}">${team.nameTeam}</option>
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


    <h3>Список спортсменов</h3>
    <table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Имя</th>
        <th scope="col">Фамилия</th>
        <th scope="col">Отчество</th>
        <th scope="col">Биография</th>
        <th scope="col">Команда</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
        <#list atheletes as athelete>
            <tr>
                <th scope="row">${athelete.id}</th>
                <td>${athelete.name}</td>
                <td>${athelete.surname}</td>
                <td>${athelete.patronymic}</td>
                <td>${athelete.biography}</td>
                <td>${athelete.nameClub}</td>
                <td><a class="btn btn-primary" href="/athelete/${athelete.id}" role="button">Редактировать</a></td>
                <td><a class="btn btn-primary" href="/atheletedel/${athelete.id}" role="button">Удалить</a></td>
            </tr>
    </#list>
    </tbody>
    </table>
</@c.page>