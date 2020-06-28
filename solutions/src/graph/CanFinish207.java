package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/6/24 10:02 上午
 * 课程表
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 */
public class CanFinish207 {
    /**
     * 广度优先遍历，先处理完所有入度为0的课程（就是不依赖其他课程的课程）
     * 处理完毕之后将所有依赖该门课程的其他课程的入度减一，如果此时该门课程的入度也为0了
     * 将改门课程加入队列中，然后回到第一步
     * */
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        // 构建一个数组存储入度表
        int[] indegrees = new int[numCourses];
        // 构建一个List存储边信息, 如: [1,0], [2,0], [3,0], [3,1]的边信息存储为[[1,2,3],[3],[],[]]
        // 表示了0和1,2,3相邻, 3和1相邻
        List<List<Integer>> adj = new ArrayList<>();
        // 构建一个队列用于广度优先遍历，每次都将入度为0的课程加入队列，然后不断出队列
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        // 生成入度表和边信息
        for (int[] cp: prerequisites) {
            indegrees[cp[0]]++;
            adj.get(cp[1]).add(cp[0]);
        }
        // 将所有入度为0的课程加入队列中
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        // 当队列不为空时，将课程pop出来，并且将与该课程相关的课程入度减一
        while (!queue.isEmpty()) {
            int course = queue.poll();
            // 找到和该课程相关的其他课程
            for (int anotherCourse: adj.get(course)) {
                // 入度减一
                indegrees[anotherCourse]--;
                // 如果此时入度为0，那么加入队列
                if (indegrees[anotherCourse] == 0) {
                    queue.add(anotherCourse);
                }
            }
            // 现在少了一门课程了
            numCourses--;
        }
        return numCourses == 0;
    }

    /**
     * 深度优先遍历
     * */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] flag = new int[numCourses];
        for (int[] cp: prerequisites) {
            adj.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adj, flag, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adj, int[] flags, int i) {
        if (flags[i] == 1) {
            return false;
        }
        if (flags[i] == -1) {
            return true;
        }
        flags[i] = 1;
        // 针对课程i，找到和i相关的课程
        for (int j: adj.get(i)) {
            if (!dfs(adj, flags, j)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }
}
