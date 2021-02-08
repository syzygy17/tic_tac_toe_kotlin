package tictactoe

fun printCells(arr: Array<CharArray>) {
    println("---------")
    for (i in 0..2) {
        println("| ${arr[i][0]} ${arr[i][1]} ${arr[i][2]} |")
    }
    println("---------")
}

fun main() {
    val arr: Array<CharArray> = Array(3) { CharArray(3) }
    for (i in 0..2) {
        arr[i] = charArrayOf(' ', ' ', ' ')
    }
    var xOrO = true
    printCells(arr)
    while (true) {
        print("Enter the coordinates:")
        val coordinates = readLine()!!
        if (coordinates[0].isLetter())
            println("You should enter numbers!")
        else {
            val c = coordinates.split(" ")
            val x = c[0].toInt()
            val y = c[1].toInt()
            if (x > 3 || y > 3 || x < 1 || y < 1) {
                println("Coordinates should be from 1 to 3!")
            } else if (arr[x - 1][y - 1] != ' ') {
                println("This cell is occupied! Choose another one!")
            } else {
                if (xOrO)
                    arr[x - 1][y - 1] = 'X'
                else
                    arr[x - 1][y - 1] = 'O'
                xOrO = !xOrO
                var cells = ""
                for (i in arr) {
                    for (j in i) {
                        cells += j
                    }
                }
                printCells(arr)
                if (cells[0] == 'X' && cells[1] == 'X' && cells[2] == 'X' ||
                    cells[3] == 'X' && cells[4] == 'X' && cells[5] == 'X' ||
                    cells[6] == 'X' && cells[7] == 'X' && cells[8] == 'X' ||
                    cells[0] == 'X' && cells[3] == 'X' && cells[6] == 'X' ||
                    cells[1] == 'X' && cells[4] == 'X' && cells[7] == 'X' ||
                    cells[2] == 'X' && cells[5] == 'X' && cells[8] == 'X' ||
                    cells[0] == 'X' && cells[4] == 'X' && cells[8] == 'X' ||
                    cells[2] == 'X' && cells[4] == 'X' && cells[6] == 'X'
                ) {
                    println("X wins")
                    break
                }
                if (cells[0] == 'O' && cells[1] == 'O' && cells[2] == 'O' ||
                    cells[3] == 'O' && cells[4] == 'O' && cells[5] == 'O' ||
                    cells[6] == 'O' && cells[7] == 'O' && cells[8] == 'O' ||
                    cells[0] == 'O' && cells[3] == 'O' && cells[6] == 'O' ||
                    cells[1] == 'O' && cells[4] == 'O' && cells[7] == 'O' ||
                    cells[2] == 'O' && cells[5] == 'O' && cells[8] == 'O' ||
                    cells[0] == 'O' && cells[4] == 'O' && cells[8] == 'O' ||
                    cells[2] == 'O' && cells[4] == 'O' && cells[6] == 'O'
                ) {
                    println("O wins")
                    break
                }
                var k = 0
                for (i in arr) {
                    for (j in i) {
                        if (j != ' ') k++
                    }
                }
                if (k == 9) {
                    println("Draw")
                    break
                }
            }
        }
    }
}