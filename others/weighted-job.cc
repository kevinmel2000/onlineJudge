typedef pair<int,int> Interval;
 
bool compare(Interval& a, Interval& b){
    if(a.second==b.second) return a.first<b.first;
    return a.second<b.second;
}
 
int weightedJob(vector<Interval>& a)
{
    sort(a.begin(), a.end(), compare);
   
    int dp[n];
    int max=0;
    dp[0]=a[0];
   
    for(int i=1;i<a.size();i++) {
        dp[i]=a[i];
        for(int j=0;j<i;j++){
            if(noOverlapping(a[j], a[i]) && dp[j]+a[i]>dp[i]) {
                dp[i]=dp[j]+a[i];
            }
        }
        if(dp[i]>max) max=dp[i]
    }
    return max;
}
 
bool noOverlapping(Interval& a, Interval& b){
    if(a.first<b.second && a.second<b.first) return false;
    return true;
}
