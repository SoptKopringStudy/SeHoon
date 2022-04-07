package com.example.springbootkotlin

import com.example.springbootkotlin.web.dto.Food
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class SpringbootkotlinApplication

fun main(args: Array<String>) {

    // 1. KStack
    class KStack<T> {
        val list = mutableListOf<T>()

        fun push(item: T) = list.add(item)
        fun pop(): T = list.removeLast()
        fun size(): Int = list.size
        fun find(item: T): Boolean = list.contains(item)
    }

    // 2. 괄호 문제
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    for (i in 0 until n) {
        val kstack = KStack<Char>()
        val ps = sc.next()
        var isVPS = true

        for (item in ps) {
            // 열린 괄호
            if (item == '(') { kstack.push(')') }
            else {
                if (kstack.size() == 0) {
                    isVPS = false
                    break
                }
                kstack.pop()
            }
        }
        val result = if (kstack.size() == 0 && isVPS) "YES" else "NO"
        print(result)
    }
    // 3. 영수증
    fun printReceipt(foods: List<Food>) {
        foods.forEach {
            println("${it.name} ${it.price}원")
        }

        println("----------------")

        val total: Int = foods.sumOf { it.price }
        println("총합 ${total}원")
    }

    val menu: List<Food> = listOf(
        Food("돼지목살", 6000),
        Food("제로콜라", 2000),
        Food("민트초코오레오", 1500),
        Food("진라면순한맛", 1000),
    )

    printReceipt(menu)

//    runApplication<KopringServerApplication>(*args)
}
