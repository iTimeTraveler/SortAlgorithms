## 八大排序算法耗时对比

当int数组长度分别为 10, 30, 100, 300, 1000, 3000 时，使用排序算法对对应的数组进行排序，耗时结果如下。


### Arrays of length 10

| Algorithm      |     Random | 95% sorted |     Sorted |
| :------------- | ---------: | ---------: | ---------: |
| Insertion sort | 0.004615ms | 0.000785ms | 0.000023ms |
| Shell sort     | 0.007287ms | 0.002860ms | 0.002230ms |
| Selection sort | 0.001599ms | 0.000809ms | 0.000059ms |
| Heap sort      | 0.002094ms | 0.002083ms | 0.002085ms |
| Bubble sort    | 0.004517ms | 0.000814ms | 0.000063ms |
| Quicksort      | 0.001377ms | 0.001586ms | 0.001786ms |
| Merge sort     | 0.004518ms | 0.000778ms | 0.000026ms |
| Radix sort     | 0.000644ms | 0.000646ms | 0.000645ms |

### Arrays of length 30

| Algorithm      |     Random | 95% sorted |     Sorted |
| :------------- | ---------: | ---------: | ---------: |
| Insertion sort | 0.123324ms | 0.000604ms | 0.000054ms |
| Shell sort     | 0.139223ms | 0.026520ms | 0.025894ms |
| Selection sort | 0.015083ms | 0.001262ms | 0.000680ms |
| Heap sort      | 0.017556ms | 0.017629ms | 0.018402ms |
| Bubble sort    | 0.122594ms | 0.001022ms | 0.000486ms |
| Quicksort      | 0.011668ms | 0.015174ms | 0.016193ms |
| Merge sort     | 0.123781ms | 0.000607ms | 0.000055ms |
| Radix sort     | 0.002077ms | 0.002150ms | 0.002108ms |

### Arrays of length 100

| Algorithm      |     Random | 95% sorted |     Sorted |
| :------------- | ---------: | ---------: | ---------: |
| Insertion sort | 5.751262ms | 0.056025ms | 0.000166ms |
| Shell sort     | 5.378896ms | 0.393119ms | 0.337421ms |
| Selection sort | 0.199311ms | 0.064833ms | 0.010262ms |
| Heap sort      | 0.203811ms | 0.203682ms | 0.205747ms |
| Bubble sort    | 5.898053ms | 0.061130ms | 0.004886ms |
| Quicksort      | 0.137751ms | 0.177324ms | 0.191210ms |
| Merge sort     | 5.882192ms | 0.056593ms | 0.000167ms |
| Radix sort     | 0.006145ms | 0.006067ms | 0.006044ms |

### Arrays of length 300

| Algorithm      |       Random |  95% sorted |     Sorted |
| :------------- | -----------: | ----------: | ---------: |
| Insertion sort | 142.971101ms | 12.366163ms | 0.000506ms |
| Shell sort     | 105.500973ms | 13.471134ms | 4.468945ms |
| Selection sort |   2.007829ms |  1.323869ms | 0.107584ms |
| Heap sort      |   2.159838ms |  2.144288ms | 2.174938ms |
| Bubble sort    | 142.216001ms | 12.115499ms | 0.040407ms |
| Quicksort      |   1.330195ms |  1.654192ms | 1.971377ms |
| Merge sort     | 144.561227ms | 12.521661ms | 0.000508ms |
| Radix sort     |   0.029518ms |  0.028453ms | 0.028831ms |

### Arrays of length 1000

| Algorithm      |        Random |   95% sorted |      Sorted |
| :------------- | ------------: | -----------: | ----------: |
| Insertion sort | 5649.939294ms | 360.765524ms |  0.001362ms |
| Shell sort     | 4399.805254ms | 310.691632ms | 43.263064ms |
| Selection sort |   23.631708ms |  22.496570ms |  1.237903ms |
| Heap sort      |   23.676803ms |  23.326309ms | 23.421163ms |
| Bubble sort    | 5807.787855ms | 363.755447ms |  0.438336ms |
| Quicksort      |   15.424505ms |  16.081330ms | 22.285714ms |
| Merge sort     | 5822.908516ms | 355.370353ms |  0.001390ms |
| Radix sort     |    0.097762ms |   0.097361ms |  0.126791ms |

### Arrays of length 3000

| Algorithm      |          Random |     95% sorted |       Sorted |
| :------------- | --------------: | -------------: | -----------: |
| Insertion sort | 171271.760752ms | 11119.063850ms |   0.004004ms |
| Shell sort     | 116029.883053ms |  8348.448500ms | 502.211498ms |
| Selection sort |    229.224797ms |   203.127196ms |  11.105693ms |
| Heap sort      |    235.891323ms |   230.794397ms | 228.503595ms |
| Bubble sort    | 177897.584737ms | 11223.376504ms |   3.845661ms |
| Quicksort      |    151.487124ms |   162.464997ms | 217.498977ms |
| Merge sort     | 171893.042008ms | 11281.756808ms |   0.004078ms |
| Radix sort     |      0.427945ms |     0.416584ms |   0.417483ms |
