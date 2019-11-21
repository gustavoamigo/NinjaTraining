package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MergeAccounts {


  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, String> emailName = new HashMap<>();
    Map<String, Set<String>> graph = new HashMap<>();
    for(List<String> account: accounts) {
      String name = null;
      String previousEmail = null;
      for(String email: account) {
        if(name == null) {
          name = email;
        } else {
          emailName.put(email, name);
          graph.putIfAbsent(email, new HashSet<>());
          if(previousEmail != null) {
            graph.get(previousEmail).add(email);
            graph.get(email).add(previousEmail);
          }
          previousEmail = email;
        }
      }
    }

    Set<String> visited = new HashSet<>();
    List<List<String>> result = new ArrayList<>();
    for(String email: graph.keySet()) {
      List<String> merged = new ArrayList<>();
      dfs(visited, graph, email, merged);
      if(merged.size() > 0) {
        Collections.sort(merged);
        merged.add(0, emailName.get(email));
        result.add(merged);
      }
    }
    return result;
  }

  private void dfs(Set<String> visited, Map<String, Set<String>> graph, String email, List<String> merged) {
    if(visited.add(email)) {
      merged.add(email);
      for(String neighbor: graph.get(email)) {
        dfs(visited, graph, neighbor, merged);
      }
    }
  }

  public static void main(String[] args) {
    MergeAccounts mergeAccounts = new MergeAccounts();

    List<List<String>> accounts = new LinkedList<>();
    accounts.add(Arrays.asList("David", "David0@m.co", "David1@m.co"));
    accounts.add(Arrays.asList("David","David3@m.co","David4@m.co"));
    accounts.add(Arrays.asList("David","David4@m.co","David5@m.co"));
    accounts.add(Arrays.asList("David","David2@m.co","David3@m.co"));
    accounts.add(Arrays.asList("David","David1@m.co","David2@m.co"));
    List<List<String>> lists = mergeAccounts.accountsMerge(accounts);


  }
}
