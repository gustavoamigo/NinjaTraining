package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class MergeAccountsDfs {
  /*
   1 [n1, a@, b@]
   2 [n1, d@, b@, c@]
   3 [n1, a@, e@]
   4 [n2, a@, z@]

   1 - 2

   a@, b@ -> n1



1 ["David","David0@m.co","David1@m.co"]
2 ["David","David3@m.co","David4@m.co"]
3 ["David","David4@m.co","David5@m.co"]
4 ["David","David2@m.co","David3@m.co"]
5 ["David","David1@m.co","David2@m.co"]

[["Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"],
["Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"],
["Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"],
["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"],
["Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"]]
   */

  ArrayList<Set<String>> accountsEmails = new ArrayList<>();
  ArrayList<String> accountsNames = new ArrayList<>();

  private void dfs(Integer current, Set<Integer> visited) {
    for(int next = 0; next< accountsEmails.size(); next++) {
      if(next != current && !visited.contains(next)
          && accountsEmails.get(next).size() > 0
          && accountsEmails.get(current).size() > 0) {
        if(tryCombine(current, next)) {
          Set<Integer> nextVisted = new HashSet<>(visited);
          nextVisted.add(next);
          dfs(next, nextVisted);
        }
      }
    }
  }

  private boolean tryCombine(int firstIndex, int secondIndex) {

    String firstName = accountsNames.get(firstIndex);
    String secondName = accountsNames.get(secondIndex);
    if(!firstName.equals(secondName)) return false;

    Set<String> firstEmails = accountsEmails.get(firstIndex);
    Set<String> secondEmails = accountsEmails.get(secondIndex);

    boolean intersects = false;
    for(String email: firstEmails) {
      if(secondEmails.contains(email)) {
        intersects = true;
        break;
      }
    }
    if(intersects) {
      secondEmails.addAll(firstEmails);

      accountsEmails.set(firstIndex, new TreeSet<>());
      accountsEmails.set(secondIndex, secondEmails);
      return true;
    } else {
      return false;
    }
  }

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    accountsEmails = new ArrayList<>(accounts.size());
    accountsNames = new ArrayList<>(accounts.size());

    for(List<String> account: accounts) {
      accountsEmails.add( new TreeSet<>(account.subList(1, account.size())));
      accountsNames.add(account.get(0));
    }

    for(int next = 0; next< accountsEmails.size(); next++) {
      HashSet<Integer> path = new HashSet<>();
      path.add(next);
      dfs(next, path);
    }

    List<List<String>> result = new LinkedList<>();

    for(int x = 0; x< accountsEmails.size(); x++) {
      if(accountsEmails.get(x).size()>0) {
        List<String> newAccount = new LinkedList<>();
        newAccount.add(accountsNames.get(x));
        newAccount.addAll(accountsEmails.get(x));
        result.add(newAccount);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    MergeAccountsDfs mergeAccounts = new MergeAccountsDfs();

    List<List<String>> accounts = new LinkedList<>();
    accounts.add(Arrays.asList("David", "David0@m.co", "David1@m.co"));
    accounts.add(Arrays.asList("David","David3@m.co","David4@m.co"));
    accounts.add(Arrays.asList("David","David4@m.co","David5@m.co"));
    accounts.add(Arrays.asList("David","David2@m.co","David3@m.co"));
    accounts.add(Arrays.asList("David","David1@m.co","David2@m.co"));
    List<List<String>> lists = mergeAccounts.accountsMerge(accounts);

  }
}
