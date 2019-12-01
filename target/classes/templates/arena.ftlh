<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить новую арену
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data" action="/addarena">
                <div class="form-group">
                    <input type="text" class="form-control" name="nameArena" placeholder="Название" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="numberOfSeats" placeholder="Вместимость">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="freeSpace" placeholder="Свободные места">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="costTicket" placeholder="Цена билета">
                </div>

                <input type="hidden" name="_csrf" value="${_csrf.token}">

                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>
    </div>
    <h3>Список арен</h3>

    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Название</th>
                <th scope="col">Кол-во мест</th>
                <th scope="col">Свободные места</th>
                <th scope="col">Цена билета</th>
                <th scope="col">Соревнования</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <#list arenas as arena>
                <tr>
                    <th scope="row">${arena.id}</th>
                    <td>${arena.nameArena}</td>
                    <td>${arena.numberOfSeats}</td>
                    <td>${arena.freeSpace}</td>
                    <td>${arena.costTicket}</td>
                    <td><#list arena.versus as versus>${versus.nameCompetition}<#sep>,</#sep>
                        <#else>
                        No competition
                        </#list></td>
                    <td><a class="btn btn-primary" href="/arena/${arena.id}" role="button">Редактировать</a></td>
                    <td><a class="btn btn-primary" href="/arenadel/${arena.id}" role="button">Удалить</a></td>
                </tr>
            </#list>
        </tbody>
    </table>
</@c.page>