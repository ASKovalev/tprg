<#import "parts/common.ftlh" as c>

<@c.page>
    <h4>Team editor</h4>
    <form action="/team" method="post" enctype="multipart/form-data">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Название : </label>
            <div class="form-group col-sm-10">
                <input type="text" name="nameTeam" class="form-control" value="${team.nameTeam}">
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Тренер : </label>
            <div class="form-group col-sm-10">
                <input type="text" name="coach" class="form-control" value="${team.coach}">
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Соревнования : </label>
            <div class="form-group col-sm-10" >
                <select class="form-control" name="tournaments" value="" required multiple>
                    <option></option>-->
                    <option value="">none</option>
                    <#list competitions as competition>
                        <option value ="${competition.id}">${competition.nameCompetition}</option>
                    </#list>
                </select>
            </div>
        </div>

        <input type="hidden" value="${team.id}" name="id">
        <input type="hidden" value="${_csrf.token}" name="_csrf">

        <button type="submit" class="btn btn-primary">Сохранить</button>
    </form>

</@c.page>