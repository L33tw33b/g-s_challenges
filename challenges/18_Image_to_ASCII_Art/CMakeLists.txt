cmake_minimum_required(VERSION 3.13.4)

project(ITA)


find_package(OpenCV 4 REQUIRED)
include_directories(${OpenCV_INCLUDE_DIRS})


add_executable(${PROJECT_NAME} ImageToASCII.cpp)
target_link_libraries(${PROJECT_NAME} ${OpenCV_LIBS})
