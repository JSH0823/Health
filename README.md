[oh-my-zsh] Can't update: not a git repository.
 ~  cd Desktop\                                           ✔  3870  21:54:36
>
 ~  cd hack                                     SIGINT(2) ↵  3871  21:54:43
cd: no such file or directory: hack
 ~  cd Desktop                                          1 ↵  3872  21:54:45
 ~/Desktop  cd hack                                       ✔  3873  21:54:46
cd: no such file or directory: hack
 ~/Desktop  cd hack                                     1 ↵  3874  21:54:47
cd: no such file or directory: hack
 ~/Desktop  ls                                          1 ↵  3874  21:54:50
 MacBook Pro
SamsungPortableSSD_1.0.app
스크린샷 2023-06-22 오전 12.53.42.png
스크린샷 2023-06-22 오전 12.59.03.png
스크린샷 2023-07-13 오전 1.17.17.png
스크린샷 2023-07-22 오전 1.00.38.png
 ~/Desktop  cd ..                                         ✔  3875  21:54:50
 ~  ls                                                    ✔  3876  21:54:52
Applications
DB_ThunderNeal.pem
Desktop
Documents
Downloads
Library
Movies
Music
Packet.pcap
Pictures
Public
Virtual Machines.localized
VirtualBox VMs
Windows Server 2016 00-08-30-167.vmwarevm
Windows Server 2016 00-20-26-086.vmwarevm
[RESULT]_%COMPUTERNAME%_NT.txt
[RESULT]_hanmin-ui-MacBookPro.local_NT.txt
__pycache__
accuracy_history.png
aws.sh
batch.sh
bitcoin.ipynb
classification.ipynb
dalma.sh
data_reader.py
db.txt
djangoServer.pem
eclipse-workspace
ex
geckodriver
git_secret_key
gophish.txt
how_to_numpy_lib.py
java_project
kks_hm.ipynb
linux_server.pem
macos.sh
myGit
node_modules
nul
opt
oracle_db_hanmin.ipynb
oradiag_hanmin
package-lock.json
package.json
seaborn-data
sql_injection_cheat.txt
train_history.png
virtual-guid
vmware.txt
 ~  cd Documents                                          ✔  3877  21:54:53
 ~/Documents  cd hack                                     ✔  3878  21:55:00
 ~/Documents/hack  cd mine                                ✔  3879  21:55:01
 ~/Documents/hack/mine  code .                            ✔  3880  21:55:02
 ~/Documents/hack/mine  cd ~                              ✔  3881  21:55:04
 ~  cat git_secret_key                                    ✔  3882  23:09:33
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
 ~  ls                                                    ✔  3883  23:10:01
Applications
DB_ThunderNeal.pem
Desktop
Documents
Downloads
Library
Movies
Music
Packet.pcap
Pictures
Public
Virtual Machines.localized
VirtualBox VMs
Windows Server 2016 00-08-30-167.vmwarevm
Windows Server 2016 00-20-26-086.vmwarevm
[RESULT]_%COMPUTERNAME%_NT.txt
[RESULT]_hanmin-ui-MacBookPro.local_NT.txt
__pycache__
accuracy_history.png
aws.sh
batch.sh
bitcoin.ipynb
classification.ipynb
dalma.sh
data_reader.py
db.txt
djangoServer.pem
eclipse-workspace
ex
geckodriver
git_secret_key
gophish.txt
how_to_numpy_lib.py
java_project
kks_hm.ipynb
linux_server.pem
macos.sh
myGit
node_modules
nul
opt
oracle_db_hanmin.ipynb
oradiag_hanmin
package-lock.json
package.json
seaborn-data
sql_injection_cheat.txt
train_history.png
virtual-guid
vmware.txt
 ~  cd Documents                                          ✔  3884  23:11:29
 ~/Documents  ls                                          ✔  3885  23:11:34
Git lab leader test.pages hack
eclasshtml                mcPro
 ~/Documents  mkdir git_health                            ✔  3886  23:11:35
 ~/Documents  cd git_health                               ✔  3887  23:11:51
 ~/Documents/git_health  ls                               ✔  3888  23:11:53
 ~/Documents/git_health  git clone https://github.com/JSH0823/Health.git
'Health'에 복제합니다...
remote: Enumerating objects: 219, done.
remote: Counting objects: 100% (219/219), done.
remote: Compressing objects: 100% (124/124), done.
remote: Total 219 (delta 74), reused 206 (delta 67), pack-reused 0
오브젝트를 받는 중: 100% (219/219), 3.56 MiB | 10.37 MiB/s, 완료.
델타를 알아내는 중: 100% (74/74), 완료.
 ~/Documents/git_health  git init                         ✔  3890  23:12:03
힌트: Using 'master' as the name for the initial branch. This default branch name
힌트: is subject to change. To configure the initial branch name to use in all
힌트: of your new repositories, which will suppress this warning, call:
힌트:
힌트: 	git config --global init.defaultBranch <name>
힌트:
힌트: Names commonly chosen instead of 'master' are 'main', 'trunk' and
힌트: 'development'. The just-created branch can be renamed via this command:
힌트:
힌트: 	git branch -m <name>
/Users/hanmin/Documents/git_health/.git/ 안의 빈 깃 저장소를 다시 초기화했습니다
 ~/Documents/git_health   master ?  git add .           ✔  3891  23:12:06
warning: 내장 깃 저장소 추가: Health
힌트: You've added another git repository inside your current repository.
힌트: Clones of the outer repository will not contain the contents of
힌트: the embedded repository and will not know how to obtain it.
힌트: If you meant to add a submodule, use:
힌트:
힌트: 	git submodule add <url> Health
힌트:
힌트: If you added this path by mistake, you can remove it from the
힌트: index with:
힌트:
힌트: 	git rm --cached Health
힌트:
힌트: See "git help submodule" for more information.
 ~/Documents/git_health   master ✚  git commit -m "health"
[master (최상위-커밋) 28479a4] health
 1 file changed, 1 insertion(+)
 create mode 160000 Health
 ~/Documents/git_health   master  git branch main       ✔  3893  23:12:21
 ~/Documents/git_health   master  git branch -M main    ✔  3894  23:12:26
 ~/Documents/git_health   main  git remote add https://github.com/hanmin0512/health_care_app.git
사용법: git remote add [<옵션>] <이름> <url>

    -f, --fetch           리모트 브랜치를 가져옵니다
    --tags                가져올 때 모든 태그와 관련 오브젝트를 가져옵니다
                          아니면 아무 태그도 가져오지 않습니다 (--no-tags)
    -t, --track <브랜치>  추적할 브랜치
    -m, --master <브랜치>
                          마스터 브랜치
    --mirror[=(push|fetch)]
                          리모트를 푸시 또는 가져올 때 사용할 미러로 설정합니다

 ~/Documents/git_health   main  git remote add origin https://github.com/hanmin0512/health_care_app.git
 ~/Documents/git_health   main  git push origin main    ✔  3897  23:13:12
To https://github.com/hanmin0512/health_care_app.git
 ! [rejected]        main -> main (fetch first)
error: 레퍼런스를 'https://github.com/hanmin0512/health_care_app.git'에 푸시하는데 실패했습니다
힌트: 리모트에 로컬에 없는 사항이 들어 있으므로 업데이트가
힌트: 거부되었습니다. 이 상황은 보통 또 다른 저장소에서 같은
힌트: 저장소로 푸시할 때 발생합니다.  푸시하기 전에
힌트: ('git pull ...' 등 명령으로) 리모트 변경 사항을 먼저
힌트: 포함해야 합니다.
힌트: 자세한 정보는 'git push --help'의 "Note about fast-forwards' 부분을
힌트: 참고하십시오.
 ~/Documents/git_health   main  git push origin +main
오브젝트 나열하는 중: 2, 완료.
오브젝트 개수 세는 중: 100% (2/2), 완료.
오브젝트 쓰는 중: 100% (2/2), 188 bytes | 188.00 KiB/s, 완료.
Total 2 (delta 0), reused 0 (delta 0), pack-reused 0
To https://github.com/hanmin0512/health_care_app.git
 + 53ee956...28479a4 main -> main (forced update)
 ~/Documents/git_health   main  ls                      ✔  3899  23:13:44
Health
 ~/Documents/git_health   main  cd health               ✔  3900  23:14:01
 ~/Documents/git_health/health   main  git add .        ✔  3901  23:14:05
 ~/Documents/git_health/health   main  git              ✔  3902  23:14:10
usage: git [-v | --version] [-h | --help] [-C <path>] [-c <name>=<value>]
           [--exec-path[=<path>]] [--html-path] [--man-path] [--info-path]
           [-p | --paginate | -P | --no-pager] [--no-replace-objects] [--bare]
           [--git-dir=<path>] [--work-tree=<path>] [--namespace=<name>]
           [--super-prefix=<path>] [--config-env=<name>=<envvar>]
           <command> [<args>]

다음은 여러가지 상황에서 자주 사용하는 깃 명령입니다:

작업 공간 시작 (참고: git help tutorial)
   clone     저장소를 복제해 새 디렉터리로 가져옵니다
   init      빈 깃 저장소를 만들거나 기존 저장소를 다시 초기화합니다

변경 사항에 대한 작업 (참고: git help everyday)
   add       파일 내용을 인덱스에 추가합니다
   mv        파일, 디렉터리, 심볼릭 링크를 옮기거나 이름을 바꿉니다
   restore   Restore working tree files
   rm        파일을 작업 폴더에서 제거하고 인덱스에서도 제거합니다

커밋 내역과 상태 보기 (참고: git help revisions)
   bisect    이진 탐색으로 버그를 만들어낸 커밋을 찾습니다
   diff      커밋과 커밋 사이, 커밋과 작업 내용 사이 등의 바뀐 점을 봅니다
   grep      패턴과 일치하는 줄을 표시합니다
   log       커밋 기록을 표시합니다
   show      여러가지 종류의 오브젝트를 표시합니다
   status    작업 폴더 상태를 표시합니다

커밋 내역을 키우고, 표시하고, 조작하기
   branch    브랜치를 만들거나, 삭제하거나, 목록을 출력합니다
   commit    바뀐 사항을 저장소에 기록합니다
   merge     여러 개의 개발 내역을 하나로 합칩니다
   rebase    커밋을 다른 베이스 끝의 최상위에서 적용합니다
   reset     현재 HEAD를 지정한 상태로 재설정화합니다
   switch    Switch branches
   tag       태그를 만들거나, 표시하거나, 삭제하거나, GPG 서명을 검증합니다

협동 작업 (참고: git help workflows)
   fetch     다른 저장소에서 오브젝트와 레퍼런스를 다운로드합니다
   pull      다른 저장소 또는 다른 로컬 브랜치에서 가져오거나 통합합니다
   push      원격 레퍼런스 및 그와 관련된 오브젝트를 업데이트합니다

'git help -a' and 'git help -g' list available subcommands and some
concept guides. See 'git help <command>' or 'git help <concept>'
to read about a specific subcommand or concept.
# health_care_app
Health Care Application

# 협업자
> <a href="https://github.com/hanmin0512">hanmin0512</a>

## 사용한 라이브러리
-  Push Alarm
  > AlarmManager, NotificationManager, SharedPreferences
-  DataBase
  > SQLite
-  Calendar
  > RecylcerView로 calendar 구현
-  그래프
  > MPAndroidChart
-  GIF
  > Glide로 삽입

## 실행 화면
> 앱 실행 첫화면 <br> ![앱실행후 첫화면](https://github.com/JSH0823/Health/assets/61398530/77c08573-afe9-41b7-aafd-22c95ebd1453) <br>

> 정보 입력 화면 <br> ![image](https://github.com/JSH0823/Health/assets/61398530/21a9813f-643d-4759-a38e-2cbde0043cb5)<br>
"README.md" 36L, 1561B# health_care_app
Health Care Application

# 협업자
> <a href="https://github.com/hanmin0512">hanmin0512</a>

## 사용한 라이브러리
-  Push Alarm
  > AlarmManager, NotificationManager, SharedPreferences
-  DataBase
  > SQLite
-  Calendar
  > RecylcerView로 calendar 구현
-  그래프
  > MPAndroidChart
-  GIF
  > Glide로 삽입

## 실행 화면
> 앱 실행 첫화면 <br> ![앱실행후 첫화면](https://github.com/JSH0823/Health/assets/61398530/77c08573-afe9-41b7-aafd-22c95ebd1453) <br>

> 정보 입력 화면 <br> ![image](https://github.com/JSH0823/Health/assets/61398530/21a9813f-643d-4759-a38e-2cbde0043cb5)<br>

> 입력 정보 확인 화면 <br> ![입력정보확인화면](https://github.com/JSH0823/Health/assets/61398530/4cbf7497-c0c7-4ca6-a41e-a53c99913da4)<br>

> 메인 화면 <br> ![image](https://github.com/JSH0823/Health/assets/61398530/959e51eb-3ccd-4682-a9f6-263fe5a8ac8a)<br>

> 평가 화면 <br> ![image](https://github.com/JSH0823/Health/assets/61398530/096ac2ec-a487-4e8b-98d4-18d5432b5969)<br>

> 푸쉬 알람 화면 <br> ![image](https://github.com/JSH0823/Health/assets/61398530/315d3ec9-b471-44ec-bf28-4cf3e9fd8de0)<br>

> 목표 달성 화면 <br> ![image](https://github.com/JSH0823/Health/assets/61398530/3a85f1d1-9210-46cd-9aba-d919b790f025)<br>

> 목표 재설정 화면 <br> ![image](https://github.com/JSH0823/Health/assets/61398530/25720e48-80dd-4abc-95d5-0a448da98cda)<br>

> 저장된 DataBase <br> ![image](https://github.com/JSH0823/Health/assets/61398530/87675d56-fa3d-4adf-ac25-62fafcf3aa92)<br>
