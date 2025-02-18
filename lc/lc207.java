package lc;


import java.util.ArrayList;
import java.util.List;

// 课程表
// 判断是否能修完全部课程

public class lc207 {
    public static List<List<Integer>> edge = new ArrayList<List<Integer>>();
    public static int[] visited;
    public static boolean valid = true;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        for(int i = 0;i < numCourses;i++){
            edge.add(new ArrayList<Integer>());
        }

        for(int i = 0;i < prerequisites.length;i++){
            int first = prerequisites[i][0];
            int second = prerequisites[i][1];
            edge.get(first).add(second);
        }

        for(int i = 0;i < numCourses && valid;i++){
            if(visited[i] == 0){
                dfs(i);
            }
        }

        return valid;
    }

    public static void dfs(int node){
        visited[node] = 1;
        for(int v: edge.get(node)){
            if(visited[v] == 0){
                dfs(v);
                if(!valid)
                    return;
            }
            else if(visited[v] == 1){
                valid = false;
                return;
            }
        }

        visited[node] = 2;
    }



    public static void main(String[] args) {
        // 测试用例
//        int numCourses = 2;
//        int[][] prerequisites = {{1, 0}, {0, 1}};
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}, {1, 3}};

        boolean result = canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses: " + result);

    }
}
