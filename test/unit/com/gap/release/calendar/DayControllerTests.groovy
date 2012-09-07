package com.gap.release.calendar



import org.junit.*
import grails.test.mixin.*

@TestFor(DayController)
@Mock(Day)
class DayControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/day/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.dayInstanceList.size() == 0
        assert model.dayInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.dayInstance != null
    }

    void testSave() {
        controller.save()

        assert model.dayInstance != null
        assert view == '/day/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/day/show/1'
        assert controller.flash.message != null
        assert Day.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/day/list'


        populateValidParams(params)
        def day = new Day(params)

        assert day.save() != null

        params.id = day.id

        def model = controller.show()

        assert model.dayInstance == day
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/day/list'


        populateValidParams(params)
        def day = new Day(params)

        assert day.save() != null

        params.id = day.id

        def model = controller.edit()

        assert model.dayInstance == day
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/day/list'

        response.reset()


        populateValidParams(params)
        def day = new Day(params)

        assert day.save() != null

        // test invalid parameters in update
        params.id = day.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/day/edit"
        assert model.dayInstance != null

        day.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/day/show/$day.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        day.clearErrors()

        populateValidParams(params)
        params.id = day.id
        params.version = -1
        controller.update()

        assert view == "/day/edit"
        assert model.dayInstance != null
        assert model.dayInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/day/list'

        response.reset()

        populateValidParams(params)
        def day = new Day(params)

        assert day.save() != null
        assert Day.count() == 1

        params.id = day.id

        controller.delete()

        assert Day.count() == 0
        assert Day.get(day.id) == null
        assert response.redirectedUrl == '/day/list'
    }
}
