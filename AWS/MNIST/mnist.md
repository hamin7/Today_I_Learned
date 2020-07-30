# Amazon SageMaker로 MNIST 데이터 학습시키기

Training Machine Learning Models on Amazon SageMaker라는 블로그를 참고하였습니다. 링크는 아래 주소입니다.

https://towardsdatascience.com/training-machine-learning-models-on-amazon-sagemaker-d95bd089db0d

우선 clone을 해줍니다.

![clone](../MNIST/images/clone.png)

git clone https://github.com/awslabs/amazon-sagemaker-examples.git

clone 받은 파일 중 amazon-sagemaker-examples/sagemaker-debugger/mnist_tensor_plot을 open합니다.

그리고 notebook을 open합니다.

![notebook](../MNIST/images/notebook.png)

~~~ssh
! python -m pip install plotly
! python -m pip install smdebug
!pip install sagemaker
!pip install awscli
!pip install nbformat==4.3.0
~~~

![estimator](../MNIST/images/estimator.png)

estimator 코드 입니다. training job을 configure하는 부분 입니다.

ml.m4.xlarge로 돌립니다.

![launch](../MNIST/images/launch.png)

launch를 하였으나 에러가 뜹니다.

![error](../MNIST/images/error.png)

이러한 에러가 뜨네요...