<#import "parts/common.ftlh" as c>

<@c.page>
    <h4>Competition editor</h4>
    <form action="/competition" method="post" enctype="multipart/form-data">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Название : </label>
            <div class="form-group col-sm-10">
                <input type="text" class="form-control" name="sport" value="${competition.sport}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Кол-во мест : </label>
            <div class="form-group col-sm-10">
                <input type="text" class="form-control" name="nameCompetition" value="${competition.nameCompetition}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Свободные места : </label>
            <div class="form-group col-sm-10">
                <input type="text" class="form-control" name="competitionTime" value="${competition.competitionTime}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Цена билета : </label>
            <div class="form-group col-sm-10">
                <input type="text" class="form-control" name="result" value="${competition.result}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Арена : </label>
            <div class="form-group col-sm-10">
                <select class="form-control" name="stage" value="" required>
                    <option></option>
                    <option value="">none</option>
                    <#list arenas as arena>
                        <option value ="${arena.id}">${arena.nameArena}</option>
                    </#list>
                </select>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Команды : </label>
            <div class="form-group col-sm-10">
                <select class="form-control" name="opponents" value="" required multiple>
                    <option></option>
                    <option value="">none</option>
                    <#list teams as team>
                        <option value ="${team.id}">${team.nameTeam}</option>
                    </#list>
                </select>
            </div>
        </div>


        <input type="hidden" value="${competition.id}" name="id">
        <input type="hidden" value="${_csrf.token}" name="_csrf">

        <button type="submit" class="btn btn-primary">Сохранить</button>
    </form>

</@c.page>