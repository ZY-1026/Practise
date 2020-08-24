package bishi.tencent;

public class Main2 {
}


//#include <iostream>
//#include <vector>
//#include <algorithm>
//using namespace std;
//
//        int len,k;
//        string str,result="";
//
//        bool dfs(vector<int> &cur){
//        if(k == 0) return true;
//
//        vector<vector<int>> alps(26);
//        for(int index : cur){
//        if(index+1 < len){
//        alps[str[index+1]-'a'].push_back(index+1);
//        }
//        }
//        for(int index=0;index<26;index++){
//        if(!alps[index].empty()){
//        result.push_back(str[alps[index][0]]);
//        k--;
//        if(dfs(alps[index])) return true;
//        result.pop_back();
//        }
//        }
//        return false;
//        }
//
//        int main(){
//        cin >> str;
//        cin >> k;
//        vector<int> tmp;
//        len = str.size();
//        for(int index=0;index<len;index++){
//        tmp.push_back(index-1);
//        }
//        dfs(tmp);
//        cout << result << endl;
//        return 0;
//        }
