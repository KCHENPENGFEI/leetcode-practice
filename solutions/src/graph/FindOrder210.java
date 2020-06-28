package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/6/24 12:41 下午
 *
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 */
public class FindOrder210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        // 初始化入度表和边信息
        for (int[] cp: prerequisites) {
            indegrees[cp[0]]++;
            adj.get(cp[1]).add(cp[0]);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.addLast(i);
            }
        }
        int n = numCourses;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[n - numCourses] = course;
            numCourses--;
            for (int anotherCourse: adj.get(course)) {
                indegrees[anotherCourse]--;
                if (indegrees[anotherCourse] == 0) {
                    queue.addLast(anotherCourse);
                }
            }
        }
        if (numCourses == 0) {
            return result;
        }
        return new int[]{};
    }
}
