<#import "parts/common.ftlh" as c>

<@c.page>
    <h4>Arena editor</h4>
    <form action="/arena" method="post" enctype="multipart/form-data">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Название : </label>
            <div class="form-group col-sm-10">
                <input type="text" class="form-control" name="nameArena" value="${arena.nameArena}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Кол-во мест : </label>
            <div class="form-group col-sm-10">
                <input type="text" class="form-control" name="numberOfSeats" value="${arena.numberOfSeats}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Свободные места : </label>
            <div class="form-group col-sm-10">
            <input type="text" class="form-control" name="freeSpace" value="${arena.freeSpace}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Цена билета : </label>
            <div class="form-group col-sm-10">
            <input type="text" class="form-control" name="costTicket" value="${arena.costTicket}">
            </div>
        </div>


        <input type="hidden" value="${arena.id}" name="id">
        <input type="hidden" value="${_csrf.token}" name="_csrf">

        <button type="submit" class="btn btn-primary">Сохранить</button>
    </form>

</@c.page>