# 2017 hjhjpark 박형준
*test pull*
*add multi() method*
> university : Sogang univ

> major : Computer engineering / Economics

----

## research field

* tensorflow
  * CNN
  * RNN
* data mining
  * economic analysis
  * sentimental dictionary
  * opinion mining
  * text mining
* database
  * bigdata management
  
1.  tensorflow code
```python
import tensorflow as tf
from sklearn.preprocessing import MinMaxScaler
import numpy as np

timesteps=seq_lenght=7
data_dim=5
hidden_dim=3
output_dim=1
xy=np.loadtxt('./data-02-stock_daily.csv',delimiter=',')
xy=xy[::-1]
scaler=MinMaxScaler(feature_range=(0,1))
xy=scaler.fit_transform(xy)
x=xy
y=xy[:,[-1]]

dataX=[]
dataY=[]
for i in range(0,len(y)-seq_lenght) :
    _x=x[i:i+seq_lenght]
    _y=y[i+seq_lenght]
    print(_x,"->",_y)
    dataX.append(_x)
    dataY.append(_y)

train_size=int(len(dataY)*0.7)
test_size=len(dataY)-train_size
trainX,testX=np.array(dataX[0:train_size]),np.array(dataX[train_size:len(dataX)])
trainY,testY=np.array(dataY[0:train_size]),np.array(dataY[train_size:len(dataY)])

X=tf.placeholder(tf.float32,[None,seq_lenght,data_dim])
Y=tf.placeholder(tf.float32,[None,1])

cell=tf.contrib.rnn.BasicLSTMCell(num_units=hidden_dim,state_is_tuple=True)
outputs,_states=tf.nn.dynamic_rnn(cell,X,dtype=tf.float32)
Y_pred=tf.contrib.layers.fully_connected(outputs[:-1],output_dim,activation_fn=None)

loss=tf.reduce_sum(tf.square(Y_pred-Y))
optimizer=tf.train.AdadeltaOptimizer(0.01)
train=optimizer.minimize(loss)
sess=tf.Session()
sess.run(tf.global_variables_initializer())

for i in range(1000):
    _,l=sess.run([train,loss],feed_dict={X:trainX,Y:trainY})
    print(i,l)

testPredict=sess.run(Y_pred,feed_dict={X: testX })

import matplotlib.pyplot as plt
plt.plot(testY)
plt.plot(testPredict)
plt.show()
```
  
