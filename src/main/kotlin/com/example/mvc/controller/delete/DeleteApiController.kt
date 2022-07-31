package com.example.mvc.controller.delete

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api")
@Validated
class DeleteApiController {
    // 1. path variable

    // 2. request param
    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(name = "name") _name: String,
        @NotNull(message = "age 값이 누락 되었습니다.")
        @Min(value = 20, message = "age는 20보다 커야 합니다.")
        @RequestParam(name = "age") _age: Int,
    ): String {
        println(_name)
        println(_age)

        return _name + " " + _age
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @Size(min=2, max=10)
        @NotNull(message = "name 값이 누락 되었습니다.")
        @PathVariable(value = "name") _name: String,
        @NotNull(message = "age 값이 누락 되었습니다.")
        @Min(value = 20, message = "age는 20보다 커야 합니다.")
        @PathVariable(name = "age") _age: Int,
    ): String {
        println(_name)
        println(_age)
        return _name + " " + _age
    }
}