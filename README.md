# ShardingSphere
<br /><br />
#### 初期階段：垂直分庫和垂直分表
#### 後期階段：水平分庫和水平分表

<br />

# 垂直拆分
將業務的不同分類，不同的業務劃分到不同的應用。這種拆分往往是根據系統的改造，將原來的功能模組依照更細粒度的拆分成多個弱耦合的服務

## 垂直分庫：
參考:ShardingSphere/Sharding/src/main/resources/application-sharding-user.yml<br />
<br />
按照業務模塊將數據分散到不同的數據庫中，每個數據庫存儲一個業務模塊的數據。

假設我們有一個外賣系統，包含 商品管理 訂單管理 用戶管理 三個主要業務模塊。我們可以按照業務將數據垂直拆分成三個數據庫：
![image](https://raw.githubusercontent.com/lzz0826/ShardingSphere/main/images/002.webp)
垂直拆分就是要把表按功能模塊劃分到不同數據庫中，如果你的系統是分佈式微服務的架構，那就更好理解了，一般一個微服務對應這一個或多個數據庫。比如電商系統一般都會有用戶中心、訂單、商品等等。用戶中心數據庫存的都是用戶信息相關的，商品數據庫存的都是商品相關的數據，訂單數據庫則是存的訂單相關的。

## 垂直分表：
將一個表中的列按照不同的業務邏輯拆分成多個表，以減少單個表的寬度，提高查詢性能。

設我們有一個用戶表 users，包含用戶的基本信息和詳細信息。為了優化查詢，我們可以將用戶表垂直拆分成兩個表：

![image](https://raw.githubusercontent.com/lzz0826/ShardingSphere/main/images/001.png)
垂直分表是將一張數據表的字段，拆成兩張或兩張以上的數據進行存放。這樣做的目的一個是避免一張表存的字段太多，單條數據的數據量大，不僅會佔用更多的物理內容，還會降低查詢的性能。而且有些字段查詢的不是很頻繁，有些字段查詢的很頻繁，那我們就可以將這查詢頻繁和查詢不頻繁的字段分開存放。這樣就可以避免磁盤進行不必要的IO，提高系統的性能。我們一般都是把查詢頻繁的字段放到主表中，查詢不頻繁且不是很重要的字段放到擴展表中。主表和擴展表是1對1的關係，之間用主鍵進行關聯。

## 垂直分表的優缺點總結如下：
### 優點：

- 解耦業務邏輯： 垂直分表可以將數據按照業務邏輯進行劃分，降低系統的耦合度，使得每張表只需關注特定的業務需求，提升了系統的可維護性和可擴展性。<br />

- 性能優化： 某些情況下，垂直分表可以提升性能。例如，將頻繁訪問的字段（如用戶名、密碼等）與不經常訪問的字段（如地址、電話等）分開存儲，可以減少數據庫查詢的IO消耗。<br />

- 管理與監控： 通過垂直分表，可以更精細地管理和監控數據庫的使用情況。每個表都可以有獨立的索引、統計信息和備份策略，從而更好地優化數據庫的性能和可用性。<br />

- 併發處理改善： 在高併發場景下，垂直分表可以一定程度上減少單表的併發訪問壓力，提升系統的響應速度和併發處理能力。<br />

### 缺點：

- 數據關聯複雜性增加： 垂直分表會導致數據的關聯查詢複雜化，例如，需要通過多個接口或者服務來聚合數據，增加了開發和維護的複雜度。<br />

- 分佈式事務處理困難： 垂直分表可能會增加分佈式事務處理的難度，因為涉及到跨多個表的操作，需要額外的管理和處理。<br />

- 單表數據量問題未解決： 垂直分表雖然解決了部分表結構的問題，但對於單表數據量過大的情況，依然需要考慮水平切分（即按行切分）的策略，這在大數據量或高訪問壓力下仍然是一個挑戰。<br />


<br />
<br />
<br />


## 在水平拆分之前 因該先考慮：

- 緩存優化： 使用緩存可以顯著提升系統的性能和響應速度。特別是對於讀取頻繁但不經常變化的數據，如靜態數據或者熱點數據，使用緩存可以減少數據庫的訪問壓力。<br />
- 索引優化： 確保數據庫表中的關鍵查詢字段都有合適的索引。索引可以加快查詢速度並降低數據庫的全表掃描次數，從而提高查詢效率。需要定期評估和優化索引以適應實際的查詢需求和數據變化。。<br />
- SQL 查詢優化： 優化數據庫查詢語句的結構和性能。這包括選擇最佳的查詢方式、避免使用不必要的連接和子查詢、合理利用數據庫優化器等。良好的SQL編寫實踐可以顯著改善系統的整體性能。<br />


<br />
<br />
<br />



# 水平拆分
水平拆分通常依據的主要考量是數據的均衡分佈和負載均衡

## 庫內分表：
參考:ShardingSphere/Sharding/src/main/resources/application-sharding-course.yml<br />
<br />
庫內分表是在一個數據庫中的某張表，數據行數達到了數據庫讀寫性能的瓶頸的時候，將數據平攤到數據表結構一樣的數據表中，已達到減少單張表數據，提升數據表讀寫性能的目的。
![image](https://raw.githubusercontent.com/lzz0826/ShardingSphere/main/images/005.webp)

## 分庫分表：
參考:ShardingSphere/Sharding/src/main/resources/application-sharding-course2.yml<br />
<br />
庫內分表只解決了一個庫內單張表的壓力，但是如果查詢的比較頻繁的話，庫內分表的那個數據庫的整體性能還是很容易達到瓶頸。因為一個物理機的CPU、內容、網絡IO都是有限的，所以就需要多個庫去分擔單庫的IO壓力。
分庫分表就是將原先單庫分好的數據表，平攤到各個數據庫中，目的就是為了減輕單庫的IO性能壓力
![image](https://raw.githubusercontent.com/lzz0826/ShardingSphere/main/images/006.webp)

## 水平拆分的優缺點總結如下：
### 優點：
- 單表大小可控。<br />
- 天然便於水平擴展，後期如果想對整個分片集群擴容時，只需要添加節點即可，無需對其他分片的數據進行遷移。<br />
- 使用分片字段進行範圍查找時，連續分片可快速定位分片進行快速查詢，有效避免跨分片查詢的問題。<br />
### 缺點：
- 熱點數據成為性能瓶頸。連續分片可能存在數據熱點，例如按時間字段分片，有些分片存儲最近時間段內的數據，可能會被頻繁的讀寫，而有些分片存儲的歷史數據，則很少被查詢。<br />

<br />
<br />
<br />


# 讀寫分離:

## 主從複製
![image](https://raw.githubusercontent.com/lzz0826/ShardingSphere/main/images/007.png)



### 規則(1主 2從):
參考:ShardingSphere/Sharding/src/main/resources/application-sharding-common.yml<br />
<br />
- 增刪改 主1<br />
- 查詢 從1,2<br />
- 數據同步需要在mysql中配置<br />
![image](https://raw.githubusercontent.com/lzz0826/ShardingSphere/main/images/008.png)





