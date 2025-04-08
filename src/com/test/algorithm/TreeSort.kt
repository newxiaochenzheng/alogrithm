package com.test.algorithm

import java.util.ArrayDeque
import java.util.Stack

/**
 * Description:
 * Author: zhengwuchen
 * Date: 2025/4/8
 */
class TreeSort {
    fun buildHeap(list: List<String>): TreeNode? {
        if (list.isEmpty()) {
            return null
        }
        val queue = ArrayDeque<TreeNode>()
        var index = 0
        val root = TreeNode(list[index++])
        queue.add(root)
        while (queue.isNotEmpty() && index < list.size) {
            val node = queue.removeFirst()
            val left = TreeNode(value = list[index++])
            node.left = left
            queue.add(left)

            val value = list.getOrNull(index++)
            if (value != null) {
                val right = TreeNode(value = value)
                node.right = right
                queue.add(right)
            }
        }
        return root
    }

    fun preOrderTraversal(root: TreeNode?) {
        if (root == null) {
            return
        }
        val stack = Stack<TreeNode>()
        stack.push(root)
        while (stack.isNotEmpty() ) {
            val node = stack.pop()
            print("${node.value} \t")
            if (node.right != null) {
                stack.push(node.right)
            }
            if (node.left != null) {
                stack.push(node.left)
            }
        }
    }

    fun midOderTraversal(root: TreeNode?) {
        if (root == null) {
            return
        }
        val stack = Stack<TreeNode>()
        var current = root
        while (stack.isNotEmpty() || current != null) {
            while (current != null) {
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            print("${current.value} \t")
            current = current.right
        }
    }

    fun postOderTraversal(root: TreeNode?) {
        if (root == null) {
            return
        }
        val stack = Stack<TreeNode>()
        val list = ArrayList<String>()
        stack.push(root)
        while (stack.isNotEmpty() ) {
            val node = stack.pop()
            list.add(node.value)
            if (node.left != null) {
                stack.push(node.left)
            }
            if (node.right != null) {
                stack.push(node.right)
            }
        }
        println(list.asReversed().joinToString(separator = "\t"))
    }

}

fun main() {
    val treeSort = TreeSort()
    val treeRoot = treeSort.buildHeap(listOf("A", "B", "C", "D", "E", "F", "G", "H"))
    println("preOrderTraversal")
    treeSort.preOrderTraversal(treeRoot)
    println("\n midOderTraversal")
    treeSort.midOderTraversal(treeRoot)
    println("\n postOderTraversal")
    treeSort.postOderTraversal(treeRoot)
}

class TreeNode(val value: String) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}