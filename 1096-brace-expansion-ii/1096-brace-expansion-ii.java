class Solution{
int i;
public List<String> braceExpansionII(String expression){
i=0;
return new ArrayList<>(solve(expression));
}
Set<String>solve(String s){
Set<String>res=new TreeSet<>();
Set<String>cur=new TreeSet<>();
cur.add("");
while(i<s.length()&&s.charAt(i)!='}'){
if(s.charAt(i)==','){
res.addAll(cur);
cur=new TreeSet<>();
cur.add("");
i++;
}else{
Set<String>part;
if(s.charAt(i)=='{'){
i++;
part=solve(s);
i++;
}else{
part=new TreeSet<>();
part.add(String.valueOf(s.charAt(i++)));
}
Set<String>next=new TreeSet<>();
for(String a:cur)for(String b:part)next.add(a+b);
cur=next;
}
}
res.addAll(cur);
return res;
}
}