<#import "parts/common.ftlh" as c>

<@c.page>
    <h4>Athelete editor</h4>
    <form action="/athelete" method="post" enctype="multipart/form-data">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Имя : </label>
            <div class="form-group col-sm-10">
                <input type="text" name="name" class="form-control" value="${athelete.name}">
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Фамилия : </label>
            <div class="form-group col-sm-10">
                <input type="text" name="surname" class="form-control" value="${athelete.surname}">
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Отчество : </label>
            <div class="form-group col-sm-10">
                <input type="text" name="patronymic" class="form-control" value="${athelete.patronymic}">
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Биография : </label>
            <div class="form-group col-sm-10">
                <input type="text" name="biography" class="form-control" value="${athelete.biography}">
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Команда : </label>
            <div class="form-group col-sm-10" >
                <select class="form-control" name="club" value="" required>
                    <option></option>
                    <option value="">none</option>
                    <#list teams as team>
                        <option value ="${team.id}">${team.nameTeam}</option>
                    </#list>
                </select>
            </div>
        </div>

        <input type="hidden" value="${athelete.id}" name="id">
        <input type="hidden" value="${_csrf.token}" name="_csrf">

        <button type="submit" class="btn btn-primary">Сохранить</button>
    </form>

</@c.page>