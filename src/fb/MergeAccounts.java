package fb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class MergeAccounts {


    /*
    [n1, a@, b@]
    [n1, d@, b@, c@]
    [n1, a@, e@]
    [n2, a@, z@]

    account with multiple name/email inverted index
        - if exists - add email to the account
        - else just create a new account


1 ["David","David0@m.co","David1@m.co"]
2 ["David","David3@m.co","David4@m.co"]
3 ["David","David4@m.co","David5@m.co"]
4 ["David","David2@m.co","David3@m.co"]
5 ["David","David1@m.co","David2@m.co"]

    account with multiple name/email inverted index
        - if exists - add email to the account
        - else just create a new account


    */

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    HashMap<String, Set<String>> mergedAccount = new HashMap<>();

    for(List<String> account: accounts) {
      String name = account.get(0);
      String found = null;

      for(String email: account) {
        if(email.equals(name)) continue;
        if(mergedAccount.get(emailName(name, email)) != null) {
          found = email;
        }
      }

      Set<String> emails;

      if(found == null) {
        emails = new HashSet<>();
      } else {
        emails = mergedAccount.get(emailName(name, found));
      }

      for(String email: account) {
        if(email.equals(name)) continue;
        emails.add(email);
        mergedAccount.put(emailName(name, email), emails);
      }
    }

    HashSet<List<String>> resultSet = new HashSet<>();

    for(Map.Entry<String, Set<String>> entry: mergedAccount.entrySet()) {
      TreeSet<String> emails = new TreeSet<>();

      for(String email: entry.getValue()) {
        emails.add(email);
      }

      List<String> account = new LinkedList<>();

      String[] key = entry.getKey().split(",");
      String name = key[0];
      account.add(name);

      for(String email: emails) {
        account.add(email);
      }

      resultSet.add(account);
    }

    List<List<String>> result = new LinkedList<>();
    for(List<String> account: resultSet) {
      result.add(account);
    }

    return result;

  }



  private String emailName(String name, String email) {
    return name + "," + email;
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
